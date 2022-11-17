package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UsuarioDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private String tipoUsuario;
}
