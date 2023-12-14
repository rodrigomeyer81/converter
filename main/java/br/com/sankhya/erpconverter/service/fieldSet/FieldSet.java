package br.com.sankhya.erpconverter.service.fieldSet;

import br.com.sankhya.erpconverter.dto.ResponseDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.entity.Entity;

import java.util.List;
import java.util.Map;

public interface FieldSet {

    Entity convertInput(Map<List<String>, List<String>> requestEntity);

    ResponseDTO convertOutput(ErpResponseDTO erpResponseDTO, Map<List<String>, List<String>> translate);

}
