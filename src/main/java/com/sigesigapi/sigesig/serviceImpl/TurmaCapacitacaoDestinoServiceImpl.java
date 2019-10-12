package com.sigesigapi.sigesig.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Modulo;
import com.sigesigapi.sigesig.model.TurmaCapacitacaoDestino;
import com.sigesigapi.sigesig.repository.TurmaCapacitacaoDestinoRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class TurmaCapacitacaoDestinoServiceImpl implements CommonService<TurmaCapacitacaoDestino>{

	@Autowired
	private TurmaCapacitacaoDestinoRepository turmaRepository;
	
	@Override
	public List<TurmaCapacitacaoDestino> listarTodos() {
		return turmaRepository.findAll();
	}

	@Override
	public TurmaCapacitacaoDestino salvar(TurmaCapacitacaoDestino entity) {
	
		return turmaRepository.save(entity);
	}

	@Override
	public Optional<TurmaCapacitacaoDestino> buscarId(Long id) {
		return turmaRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		turmaRepository.deleteById(id);
	}

	@Override
	public TurmaCapacitacaoDestino setDadosAtualizar(Long id, TurmaCapacitacaoDestino entity) {

		Optional<TurmaCapacitacaoDestino> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idTurmaCapacitacaoDestino");
		return salvar(retorno.get());
	}

}
