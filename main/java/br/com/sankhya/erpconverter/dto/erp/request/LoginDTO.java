package br.com.sankhya.erpconverter.dto.erp.request;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.Map;

@Builder
@Data
public class LoginDTO {
    private String NOMUSU;
    private String INTERNO;
    private String KEEPCONNECTED;

    public Map<String, String> getNomusu() {
        return Collections.singletonMap("$",NOMUSU);
    }

    public Map<String, String> getInterno() {
        return Collections.singletonMap("$",INTERNO);
    }

    public Map<String, String> getKeepconnected() {
        return Collections.singletonMap("$",KEEPCONNECTED);
    }
}
