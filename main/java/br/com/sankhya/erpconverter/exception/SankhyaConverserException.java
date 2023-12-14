package br.com.sankhya.erpconverter.exception;

public class SankhyaConverserException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public SankhyaConverserException() {
        new SankhyaConverserException(MessageError.MSG_ERR_OBJECT_GENERIC.getMensagem());
    }

    public SankhyaConverserException(String message) {
        super(message);
    }

    public SankhyaConverserException(MessageError messageError) {

        if(messageError == null) {
            messageError = MessageError.MSG_ERR_OBJECT_GENERIC;
        }
        new SankhyaConverserException(messageError.getMensagem());
    }
}