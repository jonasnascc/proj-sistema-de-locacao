package io.github.jonashnascimento.service.impl;


import io.github.jonashnascimento.domain.entity.Objeto;
import io.github.jonashnascimento.domain.entity.Tipo;
import io.github.jonashnascimento.domain.enums.StatusObjeto;
import io.github.jonashnascimento.domain.repository.LocatarioRepository;
import io.github.jonashnascimento.domain.repository.ObjetoRepository;
import io.github.jonashnascimento.domain.repository.TipoRepository;
import io.github.jonashnascimento.exception.RegraNegocioException;
import io.github.jonashnascimento.rest.dto.ObjetoDTO;
import io.github.jonashnascimento.rest.dto.TipoDTO;
import io.github.jonashnascimento.service.ObjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObjetoServiceImpl implements ObjetoService {
    private final ObjetoRepository repository;
    private final TipoRepository tipoRepository;
    private final LocatarioRepository locatarioRepository;

    @Override
    public Objeto save(ObjetoDTO dto) {
        Objeto objeto = new Objeto();

        objeto.setDono(locatarioRepository.findById(dto.getDono()).orElseThrow(() -> new RegraNegocioException("Falha ao Encontrar Locatário.")));
        objeto.setNome(dto.getNome());
        objeto.setCaracteristicas(dto.getCaracteristicas());
        objeto.setStatus(StatusObjeto.NAO_LOCADO);

        Tipo tipo = converterTipo(dto.getTipo());
        try{
            tipoRepository.save(tipo);
        } catch (Exception e){
            throw new RegraNegocioException("Erro ao definir o tipo de objeto. ( tipo duplicado)");
        }

        objeto.setTipo(tipo);

        repository.save(objeto);

        return objeto;
    }

    private Tipo converterTipo(TipoDTO dto){
        Tipo tipo = new Tipo();
        tipo.setCriador(locatarioRepository.findById(dto.getCriador()).orElseThrow(() -> new RegraNegocioException("Falha ao Encontrar Locatário.")));
        tipo.setNome(dto.getNome());
        return tipo;
    }
}
