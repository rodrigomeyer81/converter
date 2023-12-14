package br.com.sankhya.erpconverter.dto;

import br.com.sankhya.erpconverter.enuns.StatusResponse;
import br.com.sankhya.erpconverter.exception.MessageError;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ErrorDTO implements Serializable{
    private static final long serialVersionUID = 6557708915021732822L;

    private Integer codigo;

    private String descricao;


    public static ErrorDTO generation(StatusResponse status, String description){

        ErrorDTO error = null;

        if(!StatusResponse.SUCCESS.equals(status) &&
                !StatusResponse.INFO.equals(status)) {

            error = ErrorDTO.builder()
                    .codigo(status.getValue())
                    .descricao(description).build();
        }
        return error;
    }

    public static ErrorDTO generation(MessageError messageError){

        ErrorDTO error = null;

        if(messageError != null) {

            error = ErrorDTO.builder()
                    .codigo(messageError.getCodigo())
                    .descricao(messageError.getMensagem())
                    .build();
        }
        return error;
    }
}
