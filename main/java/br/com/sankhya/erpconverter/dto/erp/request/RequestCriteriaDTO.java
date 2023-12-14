package br.com.sankhya.erpconverter.dto.erp.request;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class RequestCriteriaDTO {
    private Map<String, String> expression;
}
