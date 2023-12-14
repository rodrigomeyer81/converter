package br.com.sankhya.erpconverter.dto.erp.request;

import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErpRequest {

    private String serviceName;

    private RequestBodyDTO requestBody;


    public String toJson(){
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}




