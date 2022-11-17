package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    //private Date data;
    private Integer parcelaReferencia;
    private String status;
}
