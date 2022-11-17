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
import io.github.jonashnascimento.rest.dto.TipoDTO;
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
        objeto.setNome(dto.getNome());
        objeto.setCaracteristicas(dto.getCaracteristicas());
        objeto.setStatus(StatusObjeto.NAO_LOCADO);

        TipoObjeto tipoObjeto = converterTipo(dto.getTipo());
        try{
            tipoRepository.save(tipoObjeto);
        } catch (Exception e){
            throw new RegraNegocioException("Erro ao definir o tipo de objeto. (tipo duplicado)");
        }

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

    private TipoObjeto converterTipo(TipoDTO dto){
        TipoObjeto tipoObjeto = new TipoObjeto();
        tipoObjeto.setCriador(usuarioRepository.findById(dto.getCriador()).orElseThrow(() -> new RegraNegocioException("Falha ao Encontrar Usuario.")));
        tipoObjeto.setNome(dto.getNome());
        return tipoObjeto;
    }
}
