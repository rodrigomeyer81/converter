package br.com.sankhya.erpconverter.entity;

import br.com.sankhya.erpconverter.tool.FormattingTool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Locale;

@Data
@AllArgsConstructor
@Builder
public class AndCondition implements Criteria{

    private List<String> familyTree;
    private String value;

    @Override
    public String getCondition() {

        String field = FormattingTool.concatList(familyTree, "->");
        StringBuffer condition = new StringBuffer();
        condition.append(FormattingTool.AND);
        condition.append(field);
        condition.append(" = '");
        condition.append(value);
        condition.append("'");

        return condition.toString();
    }

    public String validScript(){
        StringBuffer condition = new StringBuffer();

        if(!familyTree.equals(null)){
            if("script".equals(familyTree.get(familyTree.size() -1).toLowerCase(Locale.ROOT))){

                String field = FormattingTool.concatList(familyTree, "->");
                condition.append(field);
                condition.append(" = '");
                condition.append(value);
                condition.append("'");

                return condition.toString();
            }
        }


        return null;
    }
}