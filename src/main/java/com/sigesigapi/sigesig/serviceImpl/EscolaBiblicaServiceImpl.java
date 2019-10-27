package com.sigesigapi.sigesig.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.EscolaBiblica;
import com.sigesigapi.sigesig.repository.EscolaBiblicaRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class EscolaBiblicaServiceImpl implements CommonService<EscolaBiblica>{

	@Autowired
	private EscolaBiblicaRepository escolaBiblicarepository;
	
	@Override
	public Page<EscolaBiblica> listarTodos(Pageable pageable) {
		return escolaBiblicarepository.findAll(pageable);
	}

	@Override
	public EscolaBiblica salvar(EscolaBiblica entity) {
		return escolaBiblicarepository.save(entity);
	}

	@Override
	public Optional<EscolaBiblica> buscarId(Long id) {
		return escolaBiblicarepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		escolaBiblicarepository.deleteById(id);
	}

	@Override
	public EscolaBiblica setDadosAtualizar(Long id, EscolaBiblica escolaBiblica) {
		
		Optional<EscolaBiblica> escolaRetorno = buscarEscolaBiblica(id);
		BeanUtils.copyProperties(escolaBiblica, escolaRetorno.get(), "idEscolaBiblica");
		return escolaBiblicarepository.save(escolaRetorno.get());
	}

	public EscolaBiblica atualizarStatus(Long idEscolaBiblica, Boolean ativo) {
		
		Optional<EscolaBiblica> escolaRetorno = buscarEscolaBiblica(idEscolaBiblica);
		escolaRetorno.get().setAtivo(ativo);
		return escolaRetorno.get();
	}

	private Optional<EscolaBiblica> buscarEscolaBiblica(Long id) {
		Optional<EscolaBiblica> escolaRetorno = escolaBiblicarepository.findById(id);
		if(!escolaRetorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return escolaRetorno;
	}
}

