package br.com.sankhya.erpconverter.enuns;

import br.com.sankhya.erpconverter.service.fieldSet.FieldSet;
import br.com.sankhya.erpconverter.service.fieldSet.LoadRecords;
import br.com.sankhya.erpconverter.service.fieldSet.StandardModel;

public enum ConversionType {

    LOAD_RECORDS, STANDAR_MODEL;

    public FieldSet createFieldSet(){

        FieldSet response;

        switch (this){
            case STANDAR_MODEL:
                response = new StandardModel();
                break;

            case LOAD_RECORDS:
                response = new LoadRecords();
                break;

            default:
                response = new LoadRecords();
        }

      return response;

    }

}
