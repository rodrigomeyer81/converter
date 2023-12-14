package br.com.sankhya.erpconverter.entity;

import lombok.Data;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Data
public class Entity {

    private JSONArray fieldSet;

    private Map<String, String> translate = new HashMap<>();

    public Entity(JSONArray fieldSet) {
        this.fieldSet = fieldSet;
    }

    public Entity(JSONObject fieldSet, Map<String, String> translate) {

        JSONArray temp =new JSONArray();

        temp.add(fieldSet);

        this.fieldSet = temp;

        this.translate = translate;
    }
}
