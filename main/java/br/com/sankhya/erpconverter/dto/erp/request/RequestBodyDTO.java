package br.com.sankhya.erpconverter.dto.erp.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestBodyDTO {

    private RequestDataSetDTO dataSet;

    private Object NOMUSU;

    private Object INTERNO;

    private Object KEEPCONNECTED;
}
