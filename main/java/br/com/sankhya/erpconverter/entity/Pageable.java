package br.com.sankhya.erpconverter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pageable {

    private int pagina;

    private int elementoPorPagina;

    private Boolean maisPagina;

    private int totalPagina;

    private int totalElemento;

}
