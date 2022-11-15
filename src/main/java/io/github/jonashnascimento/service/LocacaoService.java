package io.github.jonashnascimento.service;


import io.github.jonashnascimento.domain.entity.Locacao;
import io.github.jonashnascimento.rest.dto.LocacaoDTO;

public interface LocacaoService {
    Locacao salvar(LocacaoDTO dto);
}
