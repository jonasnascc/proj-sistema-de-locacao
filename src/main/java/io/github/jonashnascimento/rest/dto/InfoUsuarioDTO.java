package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoUsuarioDTO {
    private Integer codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private String tipoUsuario;
}