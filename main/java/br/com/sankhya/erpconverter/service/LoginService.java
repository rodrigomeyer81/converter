package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.erp.request.ErpRequest;
import br.com.sankhya.erpconverter.dto.erp.request.RequestBodyDTO;

import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseLogin;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseBodyDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.enuns.TypeMethodHttp;
import br.com.sankhya.erpconverter.exception.MessageError;
import br.com.sankhya.erpconverter.exception.SankhyaConverserException;
import br.com.sankhya.erpconverter.tool.FormattingTool;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public final class LoginService {

    private static String ERROR= "errorMessage";

    private static Integer STATUS_RESPONSE_ERROR = 0;

    public static ErpRequest request(String user, String password){

        return ErpRequest.builder()
                .serviceName(TypeMethodHttp.LOGIN.getValue())
                .requestBody(RequestBodyDTO.builder()
                        .NOMUSU(FormattingTool.createDollarLayer(user))
                        .INTERNO(FormattingTool.createDollarLayer(password))
                        .KEEPCONNECTED(FormattingTool.createDollarLayer("S"))
                        .build())
                .build();
    }


    public static ErpResponseLogin response(String json) {

        ErpResponseDTO responseDTO = generationResponseDTO(json);

        if(responseDTO != null) {

            return generationErpResponseLogin(responseDTO);
        }
        throw new SankhyaConverserException(MessageError.MSG_ERR_READ_ERP_REPONSE);
    }


    private static ErpResponseDTO generationResponseDTO(String erpResponse){
        ErpResponseDTO responseDTO = null;
        try {
            responseDTO = new Gson().fromJson(erpResponse, ErpResponseDTO.class);

        }catch (JsonSyntaxException ex){

            throw new SankhyaConverserException(MessageError.MSG_ERR_READ_ERP_REPONSE);
        }
        return responseDTO;
    }



    private static ErpResponseLogin generationErpResponseLogin(ErpResponseDTO responseDTO){

        ErpResponseLogin response = new ErpResponseLogin();

        response.setStatus(responseDTO.getStatus());

        if(FormattingTool.stringToInteger(responseDTO.getStatus()) == STATUS_RESPONSE_ERROR){

            response.setServiceName(responseDTO.getServiceName());

            response.setErrorMessage(responseDTO.getStatusMessage());

        }else {

            ErpResponseBodyDTO responseBody = responseDTO.getResponseBody();

            response.setCallID(FormattingTool.mapToObject(responseBody.getCallID()));

            response.setIdusu(FormattingTool.mapToObject(responseBody.getIdusu()));

            response.setkID(FormattingTool.mapToObject(responseBody.getKID()));

            response.setJsessionid(FormattingTool.mapToObject(responseBody.getJsessionid()));
        }
        return response;
    }
}
