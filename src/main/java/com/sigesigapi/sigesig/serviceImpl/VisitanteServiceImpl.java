package com.sigesigapi.sigesig.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Visitante;
import com.sigesigapi.sigesig.repository.VisitanteRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class VisitanteServiceImpl implements CommonService<Visitante> {

	@Autowired
	private VisitanteRepository visitanteRepository;
	
	@Autowired
	private VisitanteServiceImpl visitanteServiceImpl;
	
	@Override
	public Page<Visitante> listarTodos(Pageable pageable) {
		return visitanteRepository.findAll(pageable);
	}

	@Override
	public Visitante salvar(Visitante entity) {
		return visitanteRepository.save(entity);
	}

	@Override
	public Optional<Visitante> buscarId(Long id) {
		return visitanteRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		visitanteRepository.deleteById(id);
	}

	@Override
	public Visitante setDadosAtualizar(Long idVisitante, Visitante visitante) {
		Optional<Visitante> visitanteRetorno = visitanteServiceImpl.buscarId(idVisitante);
		
		if(!visitanteRetorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(visitante, visitanteRetorno.get(), "idVisitante");
		return visitanteRepository.save(visitanteRetorno.get());
	}

}
