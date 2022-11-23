package io.github.jonashnascimento.rest.dto.info;

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
