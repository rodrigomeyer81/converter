package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.ResponseDTO;
import br.com.sankhya.erpconverter.dto.erp.request.ErpRequest;
import br.com.sankhya.erpconverter.dto.erp.request.RequestCriteriaDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.entity.Entity;
import br.com.sankhya.erpconverter.entity.RequestConverter;
import br.com.sankhya.erpconverter.enuns.TypeMethodHttp;
import br.com.sankhya.erpconverter.service.fieldSet.FieldSet;
import lombok.Getter;

@Getter
public class SearchConverter {

    private RequestConverter requestConverter;

    private ErpRequest erpRequest;

    private FieldSet fieldSet;


    public SearchConverter(RequestConverter requestConverter,int page) {
        this(requestConverter, page, 50);
    }


    public SearchConverter(RequestConverter requestConverter, int page, Integer size) {

        this.requestConverter = requestConverter;

        erpRequest = generateErpRequest(requestConverter, page, size);
    }


    public ResponseDTO responseConvert(String sson){

        return fieldSet.convertOutput(ErpResponseDTO.generation(sson), requestConverter.getTranslate());
    }


    private ErpRequest generateErpRequest(RequestConverter requestConverter,
                                                 Integer page,
                                                 Integer size){

        fieldSet = requestConverter.getType().createFieldSet();

        Entity entity = fieldSet.convertInput(requestConverter.getTranslate());

        RequestCriteriaDTO criteriaDTO = CriteriaService.createExpression(requestConverter.getCriteria());

        return ErpRequestService.converterRequest(TypeMethodHttp.GET,
                requestConverter.getRootEntity(),
                true,
                entity.getFieldSet(),
                null,
                criteriaDTO,
                entity.getTranslate(),
                page,
                size);
    }
}
