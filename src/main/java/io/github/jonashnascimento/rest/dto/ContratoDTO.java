package io.github.jonashnascimento.rest.dto;

import io.github.jonashnascimento.domain.entity.Fatura;

import java.math.BigDecimal;
import java.util.List;


public class ContratoDTO {
    private Integer n_faturas;
    private BigDecimal valorFaturas;
    private Integer intervaloDias;
    private ObjetoLocadoDTO objetosLocado;
    private List<Fatura> faturas;
}
