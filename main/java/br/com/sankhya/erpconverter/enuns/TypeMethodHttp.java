package br.com.sankhya.erpconverter.enuns;

import java.util.Arrays;

public enum TypeMethodHttp {

    POST("CRUDServiceProvider.saveRecord"),
    GET("CRUDServiceProvider.loadRecords"),
    DELETE("CRUDServiceProvider.removeRecord"),
    PUT("CRUDServiceProvider.saveRecord"),
    LOGIN("MobileLoginSP.login");

    private final String value;

    TypeMethodHttp(String value) {
        this.value = value;
    }

    public static TypeMethodHttp of(String value) {
        return Arrays.stream(TypeMethodHttp.values())
                .filter(tc -> value == tc.getValue())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getValue() {
        return value;
    }
}
