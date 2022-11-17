package io.github.jonashnascimento.rest.dto;

import io.github.jonashnascimento.domain.entity.Objeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoLocatarioDTO {
    private Integer codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private List<InfoObjetoDTO> objetosProprios;
}
