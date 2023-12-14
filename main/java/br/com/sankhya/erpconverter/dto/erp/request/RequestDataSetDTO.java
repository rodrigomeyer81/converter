package br.com.sankhya.erpconverter.dto.erp.request;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class RequestDataSetDTO {

    private String rootEntity;

    private String includePresentationFields;

    private String offsetPage;

    private String sizePage;

    private RequestDataRowDTO dataRow;

    private Object entity;

    private RequestCriteriaDTO criteria;

    private Map<String, String> translate;
}
