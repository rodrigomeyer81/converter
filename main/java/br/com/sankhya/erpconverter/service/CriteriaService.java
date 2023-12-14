package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.erp.request.RequestCriteriaDTO;
import br.com.sankhya.erpconverter.entity.Criteria;
import br.com.sankhya.erpconverter.exception.MessageError;
import br.com.sankhya.erpconverter.exception.SankhyaConverserException;
import br.com.sankhya.erpconverter.tool.FormattingTool;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public final class CriteriaService {

    public static RequestCriteriaDTO createExpression(List<Criteria> criteriaList) {

        String script ="";

        if(criteriaList != null && criteriaList.size() >0) {

            StringBuffer temp = new StringBuffer();

            for (Criteria criteria : criteriaList) {

                temp.append(criteria.getCondition());
            }
            script = removeStart(temp.toString());
        }

        Map<String, String> expression = new HashMap<>();

        expression.put(FormattingTool.DOLLAR, script);

        return RequestCriteriaDTO.builder()
                .expression(expression)
                .build();
    }


    public static String createExpression(Map<String, Object> filter){

        if(filter == null || filter.size()==0) {

            throw new SankhyaConverserException(MessageError.MSG_ERR_CREATE_EXPRESSION);
        }
        StringBuffer expression = createExpression(null, filter);

        expression.delete(expression.length() - FormattingTool.AND.length()-1, expression.length());

        return expression.toString();
    }


    public static StringBuffer createExpression(String entity, Map<String, Object> filter){

        StringBuffer expression = new StringBuffer();

        filter.forEach((key, value) -> {

            String field =getGenealogy(entity,key);

            if(value instanceof Map) {

                expression.append(createExpression(field, (Map<String, Object>) value));

            }else if (value instanceof List){

                expression.append(createExpressionOR(field, (List<Object>) value));

            }else {

                expression.append(addCondition(field, value.toString(), FormattingTool.AND));
            }
        });
        return expression;
    }


    private static String getGenealogy(String fathers, String son){

        StringBuffer genealogy= new StringBuffer();

        if(fathers != null && fathers != "" ) {

            genealogy.append(fathers);

            genealogy.append(".");
        }
        genealogy.append(son);

        return genealogy.toString();
    }


    private static StringBuffer addCondition(String key, String value, String operator){

        StringBuffer condition = new StringBuffer();

        condition.append(key);

        condition.append(" = '");

        condition.append(value);

        condition.append("' ");

        condition.append(operator);

        condition.append(" ");

        return condition;
    }


    private static StringBuffer createExpressionOR(String column, List<Object> list){

        int sizeOr = FormattingTool.OR.length() + 1;

        StringBuffer coditions = new StringBuffer();

        if(list != null && column != null) {

            for (Object value : list) {

                coditions.append(addCondition(column, value.toString(), FormattingTool.OR));
            }
            coditions.replace(coditions.length() - sizeOr, coditions.length(), FormattingTool.AND + " ");
        }
        return coditions;
    }


    public static String removeStart(String condition) {

        if (condition.startsWith(FormattingTool.AND)) {

            condition = condition.replaceFirst(FormattingTool.AND, "");
        }
        return condition;
    }
}
