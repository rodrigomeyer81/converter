package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.erp.request.RequestEntityDTO;
import br.com.sankhya.erpconverter.dto.erp.request.RequestFieldsetDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseBodyDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseEntitiesDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseMetaDataDTO;
import br.com.sankhya.erpconverter.entity.Entity;
import br.com.sankhya.erpconverter.tool.FormattingTool;
import com.google.gson.Gson;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public final class EntityService {

    private static String DOLLAR= "$";

    private static String F= "f";

    public static Entity createEntity(Map<List<String>, List<String>> requestEntity){

        JSONArray fieldSet = new JSONArray();

        for (Map.Entry<List<String>, List<String>> entry : requestEntity.entrySet()) {

            RequestEntityDTO temp = RequestEntityDTO.builder()
                    .path(FormattingTool.concatList(entry.getKey(), "."))
                    .fieldset(RequestFieldsetDTO.builder()
                            .list(FormattingTool.concatList(entry.getValue(), ", "))
                            .build())
                    .build();

            fieldSet.add(temp);
        }
        return new Entity(fieldSet);
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

                List<String> alias = translate.get(field.get("name"));

                response.add(alias);
            }
        }
        return response;
    }
}