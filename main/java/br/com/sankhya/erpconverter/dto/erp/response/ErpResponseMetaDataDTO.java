package br.com.sankhya.erpconverter.dto.erp.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErpResponseMetaDataDTO {

    private ErpResponseFieldsDTO fields;
}
