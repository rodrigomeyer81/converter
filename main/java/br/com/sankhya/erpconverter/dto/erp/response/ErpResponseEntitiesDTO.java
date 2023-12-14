package br.com.sankhya.erpconverter.dto.erp.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErpResponseEntitiesDTO {

    private String total;

    private String hasMoreResult;

    private String offsetPage;

    private String offset;

    private Object entity;

    private ErpResponseMetaDataDTO metadata;
}
