package br.com.sankhya.erpconverter.entity;

import br.com.sankhya.erpconverter.enuns.ConversionType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class RequestConverter {

    private String rootEntity;

    private Map<List<String>, List<String>> fieldSet = new HashMap<>();

    private List<Criteria> criteria = new ArrayList<>();

    private Map<List<String>, List<String>> translate = new HashMap<>();

    private ConversionType type;

    private String uri;


    public void include(RequestConverter requestConverter){
        if(requestConverter!= null){
            includeRequestEntity(requestConverter.getFieldSet());
            includeCriteria(requestConverter.getCriteria());
            includeTranslate(requestConverter.getTranslate());
        }
    }


    private void includeRequestEntity(Map<List<String>, List<String>> requestEntity) {
        if (requestEntity != null) {
            for (Map.Entry<List<String>, List<String>> entry : requestEntity.entrySet()) {
                if (this.getFieldSet().containsKey(entry.getKey())) {
                    this.getFieldSet().get(entry.getKey()).addAll(entry.getValue());
                } else {
                    this.getFieldSet().put(entry.getKey(), entry.getValue());
                }
            }
        }
    }


    private void includeCriteria(List<Criteria> criteria ){
        this.getCriteria().addAll(criteria);
    }


    private void includeTranslate(Map<List<String>,List<String>> translate){
        this.translate.putAll(translate);
    }
}