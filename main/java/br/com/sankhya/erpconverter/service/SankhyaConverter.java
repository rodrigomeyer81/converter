package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.ResponseDTO;
import br.com.sankhya.erpconverter.dto.erp.request.ErpRequest;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.entity.Entity;
import br.com.sankhya.erpconverter.entity.RequestConverter;
import br.com.sankhya.erpconverter.service.fieldSet.LoadRecords;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class SankhyaConverter {

    private RequestConverter requestConverter;

    private ErpRequest erpRequest;

    private LoadRecords loadRecords = new LoadRecords();


    public ErpRequest get(RequestConverter requestConverter){
        return this.get(requestConverter, 0);
    }


    public ErpRequest get(RequestConverter requestConverter, int page){
        return this.get(requestConverter, page, 50);
    }


    public ErpRequest get(RequestConverter requestConverter, int page, Integer size){

        this.requestConverter = requestConverter;

        Entity entity = loadRecords.convertInput(requestConverter.getFieldSet());

        erpRequest = ErpRequestService.get(requestConverter.getRootEntity(), entity,
                requestConverter.getCriteria(), page, size);

        return erpRequest;
    }


    public ResponseDTO responseConvert(String sson){

        Map<List<String>, List<String>> translateMap = new LinkedHashMap<>();
        if(requestConverter != null) {
            translateMap = requestConverter.getTranslate();
        }
        return loadRecords.convertOutput(ErpResponseDTO.generation(sson), translateMap);
    }


    public ErpRequest getErpRequest() {
        return erpRequest;
    }

}
