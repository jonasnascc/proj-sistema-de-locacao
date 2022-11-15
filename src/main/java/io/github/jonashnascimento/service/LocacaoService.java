package io.github.jonashnascimento.service;


import io.github.jonashnascimento.rest.dto.LocacaoDTO;

public interface LocacaoService {
    Integer salvar(LocacaoDTO dto);
}
