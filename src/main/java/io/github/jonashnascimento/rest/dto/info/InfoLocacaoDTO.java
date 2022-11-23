package io.github.jonashnascimento.rest.dto.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoLocacaoDTO {
    private Integer codigo;
    private String nomeLocador;
    private String cpfLocador;
    private String nomeLocatario;
    private String cpfLocatario;

    private BigDecimal valorLocacao;
    private Integer numeroParcelas;
    private Integer intervaloDias;

    private String nomeObjeto;
    private String tipoObjeto;
    private String caracteristicasObjeto;

}
