package io.github.jonashnascimento.service.impl;


import io.github.jonashnascimento.domain.entity.Objeto;
import io.github.jonashnascimento.domain.entity.TipoObjeto;
import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.enums.StatusObjeto;
import io.github.jonashnascimento.domain.repository.ObjetoRepository;
import io.github.jonashnascimento.domain.repository.TipoRepository;
import io.github.jonashnascimento.domain.repository.UsuarioRepository;
import io.github.jonashnascimento.exception.ObjetoNaoEncontradoException;
import io.github.jonashnascimento.exception.RegraNegocioException;
import io.github.jonashnascimento.rest.dto.ObjetoDTO;
import io.github.jonashnascimento.service.ObjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObjetoServiceImpl implements ObjetoService {
    private final ObjetoRepository repository;
    private final TipoRepository tipoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Objeto save(ObjetoDTO dto) {
        Objeto objeto = new Objeto();
        Usuario dono = usuarioRepository.findById(dto.getDono()).orElseThrow(() -> new RegraNegocioException("Falha ao Encontrar Usuário."));

        objeto.setDono(dono);
        objeto.setDescricao(dto.getDescricao());
        objeto.setCaracteristicas(dto.getCaracteristicas());
        objeto.setStatus(StatusObjeto.NAO_LOCADO);

        TipoObjeto tipoObjeto = validarTipo(dto.getTipo(), dono.getId());
        tipoRepository.save(tipoObjeto);

        objeto.setTipo(tipoObjeto);

        repository.save(objeto);

        return objeto;
    }

    @Override
    public void update(Integer id, Objeto objeto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Objeto> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void atualizaStatus(Integer id, StatusObjeto status) {
        repository.findById(id).map(objeto -> {
            objeto.setStatus(status);
            return repository.save(objeto);
        }).orElseThrow(ObjetoNaoEncontradoException::new);
    }

    private TipoObjeto validarTipo(String nome, Integer donoId){
        return tipoRepository.findByNome(nome).orElse(new TipoObjeto(nome,
                        usuarioRepository.findById(donoId).orElseThrow(() -> new RegraNegocioException("Codigo de usuário inválido."))));
    }
}
