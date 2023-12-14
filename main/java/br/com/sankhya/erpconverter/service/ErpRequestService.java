package br.com.sankhya.erpconverter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.sankhya.erpconverter.dto.erp.request.ErpRequest;
import br.com.sankhya.erpconverter.dto.erp.request.RequestBodyDTO;
import br.com.sankhya.erpconverter.dto.erp.request.RequestCriteriaDTO;
import br.com.sankhya.erpconverter.dto.erp.request.RequestDataRowDTO;
import br.com.sankhya.erpconverter.dto.erp.request.RequestDataSetDTO;
import br.com.sankhya.erpconverter.dto.erp.request.RequestEntityDTO;
import br.com.sankhya.erpconverter.dto.erp.request.RequestFieldsetDTO;
import br.com.sankhya.erpconverter.entity.Criteria;
import br.com.sankhya.erpconverter.entity.Entity;
import br.com.sankhya.erpconverter.enuns.TypeMethodHttp;
import br.com.sankhya.erpconverter.tool.FormattingTool;

public final class ErpRequestService {

    private final static String F = "f";


    public static ErpRequest get(String rootEntity,
                                 Entity entity,
                                 List<Criteria> criteriaList,
                                 Integer page,
                                 Integer size){

        RequestCriteriaDTO criteriaDTO = CriteriaService.createExpression(criteriaList);

        return converterRequest(TypeMethodHttp.GET,
                rootEntity,
                true,
                entity.getFieldSet(),
                null,
                criteriaDTO,
                entity.getTranslate(),
                page,
                size);
    }


    public static ErpRequest post(String rootEntity,
                                  Boolean includeFields,
                                  List<String> fieldSet,
                                  Object fields){

        RequestDataRowDTO dataRow = RequestDataRowDTO.builder()
                .localFields(formatLocalFields(fields))
                .build();

        RequestEntityDTO requestEntityDTO = RequestEntityDTO.builder()
                .fieldset(RequestFieldsetDTO.builder()
                        .list(FormattingTool.concatList(fieldSet, ", "))
                        .build())
                .build();

        return converterRequest(TypeMethodHttp.POST,
                rootEntity,
                includeFields,
                Arrays.asList(requestEntityDTO),
                dataRow,
                null,
                null,
                null,
                null);
    }
    
    public static ErpRequest post(String rootEntity,
                                  Boolean includeFields,
                                  List<String> fieldSet,
                                  Object fields,
                                  Object key){

        RequestDataRowDTO dataRow = RequestDataRowDTO.builder()
                .localFields(formatLocalFields(fields))
                .key(formatLocalFields(key))
                .build();

        RequestEntityDTO requestEntityDTO = RequestEntityDTO.builder()
                .fieldset(RequestFieldsetDTO.builder()
                        .list(FormattingTool.concatList(fieldSet, ", "))
                        .build())
                .build();

        return converterRequest(TypeMethodHttp.POST,
                rootEntity,
                includeFields,
                Arrays.asList(requestEntityDTO),
                dataRow,
                null,
                null,
                null,
                null);
    }


    public static ErpRequest converterRequest(TypeMethodHttp methodHttp,
                                              String rootEntity,
                                              Boolean includeFields,
                                              Object fieldSet,
                                              RequestDataRowDTO dataRow,
                                              RequestCriteriaDTO criteriaDTO,
                                              Map<String, String> translate,
                                              Integer page,
                                              Integer size){

        return ErpRequest.builder()
                .serviceName(methodHttp.getValue())
                .requestBody(RequestBodyDTO.builder()
                        .dataSet(RequestDataSetDTO.builder()
                                .rootEntity(rootEntity)
                                .includePresentationFields(FormattingTool.booleanToChar(includeFields))
                                .criteria(criteriaDTO)
                                .dataRow(dataRow)
                                .entity(fieldSet)
                                .translate(translate)
                                .offsetPage(String.valueOf(page))
                                .sizePage(String.valueOf(size))
                                .build())
                        .build())
                .build();
    }


    private static List<Map<String, Map<String, String>>> formatLocalFields(Object localFields) {

        if(localFields instanceof String){

            return formatLocalFieldsJson((String) localFields);
        }
        String json = FormattingTool.toJson(localFields);

        return formatLocalFields(json);
    }


    private static List<Map<String, Map<String, String>>> formatLocalFieldsJson(String json){

        Object temp = FormattingTool.jsonToListMap(json);

        List<Map<String, Object>> list = FormattingTool.objectToListMap(temp);

        return formatLocalFieldsListMap(list);
    }


    private static List<Map<String, Map<String, String>>> formatLocalFieldsListMap(List<Map<String, Object>> list) {

        List<Map<String, Map<String, String>>> response = new ArrayList<>();

        for ( Map<String, Object> map : list) {

            response.add(converterDollar(map));
        }
        return response;
    }


    private static Map<String, Map<String, String>> converterDollar(Map<String, Object> map) {

        Map<String, Map<String, String>> response = new HashMap<>();

        for (String key : map.keySet()) {

            response.putAll(FormattingTool.createDollarLayer(key.toUpperCase(), map.get(key)));
        }
        return response;
    }


    private static Map<String, Map<String, String>> converterF(Map<String, Object> map) {

        Map<String, Map<String, String>> response = new HashMap<>();

        int cont= 0;

        for (String key : map.keySet()) {

            cont++;

            response.putAll(FormattingTool.createMiddleLayer(key, map.get(key),F+cont));
        }
        return response;
    }

}