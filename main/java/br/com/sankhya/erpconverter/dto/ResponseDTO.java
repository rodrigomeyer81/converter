package br.com.sankhya.erpconverter.dto;

import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.entity.Pageable;
import br.com.sankhya.erpconverter.enuns.StatusResponse;
import br.com.sankhya.erpconverter.exception.MessageError;
import br.com.sankhya.erpconverter.tool.FormattingTool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseDTO {

    private StatusResponse status;

    private Object dados;

    private ErrorDTO erro;

    private Pageable paginacao;



    public static ResponseDTO generation(ErpResponseDTO erpResponse) {
        return generation(erpResponse, erpResponse.getResponseBody().getDados(), erpResponse.getResponseBody().getPaginacao());

    }

    public static ResponseDTO generation(ErpResponseDTO erpResponse, Object dados, Pageable pageable) {

        ResponseDTO response;

        ErrorDTO error;

        if(erpResponse != null) {

            StatusResponse status = StatusResponse.of(FormattingTool.stringToInteger(erpResponse.getStatus()));

            error = ErrorDTO.generation(status, erpResponse.getStatusMessage());

            response = new ResponseDTO(status, dados, error, pageable);

        }else {

            response = generation(MessageError.MSG_ERR_READ_ERP_REPONSE);
        }
        return response;
    }


    public static  ResponseDTO generation(MessageError messageError){
        return ResponseDTO.builder()
                .erro(ErrorDTO.generation(messageError))
                .build();
    }
}
