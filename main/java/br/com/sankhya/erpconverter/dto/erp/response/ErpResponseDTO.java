package br.com.sankhya.erpconverter.dto.erp.response;

import br.com.sankhya.erpconverter.exception.MessageError;
import br.com.sankhya.erpconverter.exception.SankhyaConverserException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ErpResponseDTO {

    private String serviceName;

    private String status;

    private HttpStatus httpStatus;

    private String pendingPrinting;

    private String transactionId;

    private ErpResponseBodyDTO responseBody;

    private ErpResponseTsErrorDTO tsError;

    private String statusMessage;


    public static ErpResponseDTO generation(String sson){

        ErpResponseDTO responseDTO = null;

        try {
            responseDTO = new Gson().fromJson(sson, ErpResponseDTO.class);

        }catch (JsonSyntaxException ex){

            throw new SankhyaConverserException(MessageError.MSG_ERR_READ_ERP_REPONSE);
        }
        return responseDTO;
    }
}




