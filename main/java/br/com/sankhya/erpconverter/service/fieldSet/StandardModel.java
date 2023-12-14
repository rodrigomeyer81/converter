package br.com.sankhya.erpconverter.service.fieldSet;

import br.com.sankhya.erpconverter.dto.ResponseDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.entity.Entity;
import lombok.Data;
import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public final class StandardModel implements FieldSet{

    @Override
    public Entity convertInput(Map<List<String>, List<String>> requestEntity){

        JSONObject fieldSet = new JSONObject();

        Map<String, String> translate = new HashMap<>();

        for (Map.Entry<List<String>, List<String>> entry : requestEntity.entrySet()) {

            fieldSet.merge(convertJson(entry.getKey(), entry.getValue(),translate));
        }

        return new Entity(fieldSet, translate);
    }


    @Override
    public ResponseDTO convertOutput(ErpResponseDTO erpResponse, Map<List<String>, List<String>> translate) {

        return ResponseDTO.generation(erpResponse);
    }


    private static JSONObject convertJson(List<String> nameInput, List<String> aliasInput, Map<String, String> translate){

        List<String> name = new LinkedList<>(nameInput);

        List<String> alias = new LinkedList<>(aliasInput);

        JSONObject response = new JSONObject();

        if(name.size() == 1){

            response.put(name.get(0), alias.get(0));

        }else{

            translate.put(name.get(0), alias.get(0));

            alias.remove(0);

            String entityName = name.remove(0);

            response.put(entityName, convertJson(name, alias, translate));
        }

        return response;
    }
}
