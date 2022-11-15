package io.github.jonashnascimento.rest.dto;

import java.math.BigDecimal;
import java.util.Date;


public class FaturaDTO {
    private BigDecimal valor;
    private Date data;
    private Integer parcelaReferencia;
    private boolean pagamentoEfetuado;

}
