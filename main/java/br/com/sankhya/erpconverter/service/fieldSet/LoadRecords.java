package br.com.sankhya.erpconverter.service.fieldSet;

import br.com.sankhya.erpconverter.dto.ErrorDTO;
import br.com.sankhya.erpconverter.dto.ResponseDTO;
import br.com.sankhya.erpconverter.dto.erp.request.RequestEntityDTO;
import br.com.sankhya.erpconverter.dto.erp.request.RequestFieldsetDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.entity.Entity;
import br.com.sankhya.erpconverter.entity.ResponseConverter;
import br.com.sankhya.erpconverter.enuns.StatusResponse;
import br.com.sankhya.erpconverter.service.ErpResponseService;
import br.com.sankhya.erpconverter.service.PageableService;
import br.com.sankhya.erpconverter.tool.FormattingTool;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public final class LoadRecords implements FieldSet {


    @Override
    public Entity convertInput(Map<List<String>, List<String>> requestEntity) {

        JSONArray fieldSet = new JSONArray();

        for (Map.Entry<List<String>, List<String>> entry : requestEntity.entrySet()) {

            RequestEntityDTO temp = RequestEntityDTO.builder()
                    .path(FormattingTool.concatList(entry.getKey(), "."))
                    .fieldset(RequestFieldsetDTO.builder()
                            .list(FormattingTool.concatList(entry.getValue(), ", "))
                            .build())
                    .build();

            fieldSet.add(temp);
        }
        return new Entity(fieldSet);
    }


    @Override
    public ResponseDTO convertOutput(ErpResponseDTO erpResponseDTO, Map<List<String>, List<String>> translate) {

        ResponseConverter responseConverter = ErpResponseService.convert(erpResponseDTO, translate);

        ResponseDTO response = new ResponseDTO(responseConverter.getStatus(),
                responseConverter.getEntities(),
                responseConverter.getErro(),
                PageableService.createPageable(responseConverter));

        return response;
    }


    public static ResponseConverter convert(ErpResponseDTO erpResponse, Map<List<String>, List<String>> translate) {

        if(erpResponse != null) {

            List<Map<String, Object>> entitiesDTO = ErpResponseService.converter(erpResponse.getResponseBody(), translate);

            StatusResponse status = StatusResponse.of(FormattingTool.stringToInteger(erpResponse.getStatus()));

            ErrorDTO error = ErrorDTO.generation(status, erpResponse.getStatusMessage());

            return new ResponseConverter(erpResponse, status, entitiesDTO, error);
        }
        return new ResponseConverter();
    }
}