package br.com.sankhya.erpconverter.dto.erp.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErpResponseTsErrorDTO {
    private String tsErrorCode;
    private String tsErrorLevel;
}
