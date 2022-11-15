package io.github.jonashnascimento.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocacaoDTO {
    private Integer locador;
    private Integer locatario;
    private Integer objeto;
    private ContratoDTO contrato;

}