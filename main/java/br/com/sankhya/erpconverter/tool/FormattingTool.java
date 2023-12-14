package br.com.sankhya.erpconverter.tool;

import br.com.sankhya.erpconverter.exception.MessageError;
import br.com.sankhya.erpconverter.exception.SankhyaConverserException;
import com.google.gson.Gson;

import java.util.*;

public final class FormattingTool {

    private static Gson gson = new Gson();

    private static final char SIM = 'S';

    private static final char NAO = 'N';

    public static final String DOLLAR = "$";

    public final static String AND = " AND ";

    public final static String OR = " OR ";


    public static Integer stringToInteger(String input){
        Integer response = null;
        if (input != null){
            try {
                response = Integer.valueOf(input);
            }catch (NumberFormatException e) {
            }
        }
        return response;
    }


    public static String booleanToChar(Boolean pendingPrinting){
        char pendingPrintingString;

        if(pendingPrinting == true)
            pendingPrintingString = SIM;
        else{
            pendingPrintingString = NAO;
        }
        return String.valueOf(pendingPrintingString);
    }


    public static String concatList(List<String> list, String spacer){
        StringBuffer response = new StringBuffer();
        if(list != null && list.size()>0) {
            for (Object temp : list) {
                response.append(temp.toString());
                response.append(spacer);
            }
            response.setLength(response.length() - spacer.length());
        }
        return response.toString();
    }


    public static String toJson(Object localFields) {
        try {
            return gson.toJson(localFields);

        } catch(com.google.gson.JsonSyntaxException ex) {
            throw new SankhyaConverserException();
        }
    }


    public static Object jsonToListMap(String localFields){

        try {
            return gson.fromJson(localFields, Object.class);
        } catch(com.google.gson.JsonSyntaxException ex) {
            throw new SankhyaConverserException();
        }
    }


    public static List<Map<String, Object>> objectToListMap(Object object){

        List<Map<String, Object>> response = new ArrayList<>();

        if(object instanceof List){
            response = (List<Map<String, Object>>) object;
        }else if (object instanceof Map){
            response.add((Map<String, Object>) object);

        } else {
            throw new SankhyaConverserException(MessageError.MSG_ERR_OBJECT_TO_LISTMAP);
        }
        return response;
    }


    public static Object mapToObject(Object object){
        Object response = null;
        if (object instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) object;
            response = map.get(DOLLAR);
        }
        return response;
    }


    public static Map<String, Map<String, String>> createDollarLayer(String key, Object value) {
        return createMiddleLayer(key, value, DOLLAR);
    }

    public static Map<String, String> createDollarLayer(Object value) {
        return createLayer(DOLLAR, value);
    }

    public static Map<String, Map<String, String>> createMiddleLayer(String key, Object value, String undesirable) {

        Map<String, Map<String, String>> response = new HashMap<>();

        response.put(key,  createLayer(undesirable, value.toString()));

        return response;
    }

    public static Map<String, String> createLayer(String key, Object value) {

        Map<String, String> response = new HashMap<>();

        response.put(key, value.toString());

        return response;
    }

    public static List<String> separateText(String text, String connection){
        List<String> response = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(text, connection);
        while (st.hasMoreTokens()){
            response.add(st.nextToken());
        }
        return response;
    }
}
