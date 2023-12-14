package br.com.sankhya.erpconverter.dto.erp.response;

import com.google.gson.GsonBuilder;
import lombok.Getter;

@Getter
public class ErpResponseLogin {

    private String serviceName;

    private String idusu;

    private String kID;

    private String jsessionid;

    private String callID;

    private String errorMessage;

    private String status;


    public String toJson(){
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }

    public void setIdusu(Object idusu) {
        if(idusu == null){
            this.idusu = "";
        }else {
            this.idusu = idusu.toString();
        }
    }

    public void setkID(Object kID) {
        if(kID == null){
            this.kID = "";
        }else {
            this.kID = kID.toString();
        }
    }

    public void setJsessionid(Object jsessionid) {
        if(jsessionid == null){
            this.jsessionid = "";
        }else {
            this.jsessionid = jsessionid.toString();
        }
    }

    public void setCallID(Object callID) {
        if(callID == null){
            this.callID = "";
        }else {
            this.callID = callID.toString();
        }
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
