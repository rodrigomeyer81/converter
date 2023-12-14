package br.com.sankhya.erpconverter.dto.erp.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class RequestDataRowDTO {

    List<Map<String, Map<String, String>>> localFields;
    List<Map<String, Map<String, String>>> key;

}
