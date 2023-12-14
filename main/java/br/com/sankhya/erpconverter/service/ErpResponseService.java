package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.ErrorDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseBodyDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseEntitiesDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseMetaDataDTO;
import br.com.sankhya.erpconverter.entity.ResponseConverter;
import br.com.sankhya.erpconverter.enuns.StatusResponse;
import br.com.sankhya.erpconverter.tool.FormattingTool;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ErpResponseService {

    private static String DOLLAR= "$";

    private static String F= "f";


    public ResponseConverter convert(String erpResponseJson) {
        return convert(ErpResponseDTO.generation(erpResponseJson), new LinkedHashMap<>());
    }

    public static ResponseConverter convert(ErpResponseDTO erpResponse, Map<List<String>, List<String>> translate) {

        if(erpResponse != null) {

            List<Map<String, Object>> entitiesDTO = converter(erpResponse.getResponseBody(), translate);

            StatusResponse status = StatusResponse.of(FormattingTool.stringToInteger(erpResponse.getStatus()));

            ErrorDTO error = ErrorDTO.generation(status, erpResponse.getStatusMessage());

            return new ResponseConverter(erpResponse, status, entitiesDTO, error);
        }
        return new ResponseConverter();
    }


    public static List<Map<String, Object>> converter(ErpResponseBodyDTO bodyDTO, Map<List<String>, List<String>> translate){
        List<Map<String, Object>> entity = new ArrayList<>();

        if(bodyDTO != null && bodyDTO.getEntities() != null && bodyDTO.getEntities().getEntity() != null) {

            if(bodyDTO.getEntities().getMetadata() != null && bodyDTO.getEntities().getMetadata().getFields() != null){

                List<List<String>> metaData = converterMetaData(bodyDTO.getEntities().getMetadata(), translate);

                entity = convertFModel(bodyDTO.getEntities(), metaData);

            }else {

                entity = convertDollarModel(bodyDTO.getEntities());
            }
        }
        return entity;
    }


    private static List<Map<String, Object>> convertDollarModel(ErpResponseEntitiesDTO entitiesDTO){

        List<Map<String, Object>> response = new ArrayList<>();

        List<Map<String, Object>> list = FormattingTool.objectToListMap(entitiesDTO.getEntity());

        for (Map<String, Object> entity: list) {

            Map<String, Object> temp = new HashMap<>();

            for (String key:entity.keySet()) {

                if (entity.get(key) instanceof Map){

                    temp.put(key, ((Map<?, ?>) entity.get(key)).get(DOLLAR));
                }
            }
            response.add(temp);
        }
        return response;
    }


    private static List<Map<String, Object>> convertFModel(ErpResponseEntitiesDTO entitiesDTO, List<List<String>> metaDataList){

        List<Map<String, Object>> response = new ArrayList<>();

        List<Map<String, Object>> entity = FormattingTool.objectToListMap(entitiesDTO.getEntity());

        for (Map<String, Object> field: entity) {

            Map<String, Object> map = new HashMap<>();

            for (int counter= 0; counter < metaDataList.size(); counter++) {

                List<String> key = metaDataList.get(counter);

                String f = F+counter;

                Object temp = field.get(f);

                if(temp instanceof Map) {

                    Object value = ((Map<?, ?>) temp).get(DOLLAR);

                    addResponseMap(map, key, value);
                }
            }
            response.add(map);
        }
        return response;
    }


    public static Map<String, Object> addResponseMap(Map<String,Object> entities, List<String> metaDataList, Object value){

        List<String> metaData =new ArrayList<>();

        metaData.addAll(metaDataList);

        String entity = metaData.get(0);

        if(entities == null){
            entities = new HashMap<>();
        }

        if(metaData.size() == 1){

            entities.put(entity, value);

            metaData.remove(0);

        }else{
            metaData.remove(0);

            if(entities.containsKey(entity)){

                entities.put(entity, addResponseMap((Map<String, Object>) entities.get(entity), metaData, value));
            }else{

                entities.put(entity, addResponseMap((Map<String, Object>) entities.get(entity), metaData, value));
            }
        }
        return entities;
    }


    public static List<List<String>> converterMetaData(ErpResponseMetaDataDTO metaDataDTO, Map<List<String>, List<String>> translate) {

        List<List<String>> response = new ArrayList<>();

        if (metaDataDTO != null && metaDataDTO.getFields() != null && metaDataDTO.getFields().getField() != null) {

            List<Map<String, String>> fieldsDTO = new ArrayList<>();

            if(metaDataDTO.getFields().getField() instanceof List){

                fieldsDTO = new Gson().fromJson(metaDataDTO.getFields().getField().toString(), List.class);
            }else{

                fieldsDTO.add(new Gson().fromJson(metaDataDTO.getFields().getField().toString(), LinkedHashMap.class));
            }

            for (Map<String, String> field: fieldsDTO) {

                response.add(translate.get(field.get("name")));
            }
        }
        return response;
    }
}
