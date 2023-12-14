package br.com.sankhya.erpconverter.enuns;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Locale;

public enum ErpCodeError {

    MGE_LIVROSFISCAIS("LIV"),
    MGE_MODELCORE("CORE"),
    MGE_PES_MODEL("PES"),
    MGE_PESQ("PESQ"),
    MGE_PRODUCAO("PROD"),
    MGE_SERVICO("SVC"),
    MGE_WORKFLOW("WKF"),
    MGEFIN("FIN"),
    MGECOM("COM"),
    MGEWMS("WMS"),
    MSD("MSD");

    private String value;
    ErpCodeError(String value) {
        this.value = value;
    }


    public static ErpCodeError of(String value) {
        return Arrays.stream(ErpCodeError.values())
                .filter(tc -> value == tc.getValue())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Boolean isExist(String errorCode) {
        if(!StringUtils.hasText(errorCode)) {
            return false;
        }
        errorCode = getErrErpResponsePrefix(errorCode);

        for(ErpCodeError item : ErpCodeError.values()) {
            if(errorCode.equals(item.value)) {
                return true;
            }
        }
        return false;
    }

    private static  String getErrErpResponsePrefix(String errorCode){
        if(! errorCode.contains("_")){
            return errorCode;
        }
        int underscorePosition = errorCode.indexOf("_");
        String prefix = errorCode.substring(0, underscorePosition);
        return prefix.toUpperCase(Locale.ROOT);
    }

    public String getValue() {
        return value;
    }
}
