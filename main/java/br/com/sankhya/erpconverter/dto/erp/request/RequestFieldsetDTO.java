package br.com.sankhya.erpconverter.dto.erp.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestFieldsetDTO {
    private String list;
}
