package br.com.sankhya.erpconverter.dto.erp.response;

import br.com.sankhya.erpconverter.entity.Pageable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErpResponseBodyDTO {

    private ErpResponseEntitiesDTO entities;

    private Object idusu;

    private Object kID;

    private Object jsessionid;

    private Object callID;

    private Object dados;

    private Pageable paginacao;
}
