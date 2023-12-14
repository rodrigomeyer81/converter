package br.com.sankhya.erpconverter.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum MessageError {

    MSG_ERR_OBJECT_GENERIC (3001,"Erro inesperado."),

    MSG_ERR_OBJECT_TO_LISTMAP (3001,"Erro ao converter Mapa de valores."),

    MSG_ERR_READ_ERP_REPONSE (3002,"Erro na leitura do erpResponse."),

    MSG_ERR_READ_ENTITY (3003,"Erro na leitura no corpo da requisicao."),

    MSG_ERR_CREATE_EXPRESSION (3004,"Erro ao tentar criar expresao");

    private final Integer codigo;
    private final String mensagem;

}
