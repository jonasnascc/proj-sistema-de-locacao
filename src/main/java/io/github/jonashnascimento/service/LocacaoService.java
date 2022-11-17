package io.github.jonashnascimento.service;


import io.github.jonashnascimento.domain.entity.Locacao;
import io.github.jonashnascimento.rest.dto.LocacaoDTO;

import java.util.Optional;

public interface LocacaoService {
    Locacao salvar(LocacaoDTO dto);
    Optional<Locacao> obterLocacaoCompleta(Integer id);

    Locacao update(LocacaoDTO dto);

    Locacao delete(LocacaoDTO dto);
}
