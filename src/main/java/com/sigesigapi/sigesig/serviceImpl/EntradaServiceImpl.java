package com.sigesigapi.sigesig.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Entradas;
import com.sigesigapi.sigesig.repository.EntradaRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class EntradaServiceImpl implements CommonService<Entradas>{

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Override
	public Page<Entradas> listarTodos(Pageable pageable) {
		return entradaRepository.findAll(pageable);
	}

	@Override
	public Entradas salvar(Entradas entity) {
		return entradaRepository.save(entity);
	}

	@Override
	public Optional<Entradas> buscarId(Long id) {
		return entradaRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		entradaRepository.deleteById(id);
	}

	@Override
	public Entradas setDadosAtualizar(Long id, Entradas entity) {

		Optional<Entradas> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idEntrada");
		return entradaRepository.save(retorno.get());
	}

}
