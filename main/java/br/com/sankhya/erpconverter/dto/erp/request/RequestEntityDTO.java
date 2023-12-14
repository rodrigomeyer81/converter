package br.com.sankhya.erpconverter.dto.erp.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestEntityDTO {

    private String path;

    private RequestFieldsetDTO fieldset;
}
