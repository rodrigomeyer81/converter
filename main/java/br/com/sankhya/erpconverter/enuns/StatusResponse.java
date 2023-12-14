package br.com.sankhya.erpconverter.enuns;

import java.util.Arrays;

public enum StatusResponse {

    FAIL(0),
    SUCCESS(1),
    INFO(2),
    UNAUTHORIZED(3),
    SERVICE_CANCELED(4);

    private Integer value;
    StatusResponse(Integer value) {
        this.value = value;
    }


    public static StatusResponse of(Integer value) {
        return Arrays.stream(StatusResponse.values())
                .filter(tc -> value == tc.getValue())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getValue() {
        return value;
    }



}
