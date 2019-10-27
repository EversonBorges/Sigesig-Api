package com.sigesigapi.sigesig.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Modulo;
import com.sigesigapi.sigesig.repository.ModuloRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class ModuloServiceImpl implements CommonService<Modulo>{

	@Autowired
	private ModuloRepository moduloRepository;
	
	@Override
	public Page<Modulo> listarTodos(Pageable pageable) {
		return moduloRepository.findAll(pageable);
	}

	@Override
	public Modulo salvar(Modulo entity) {
		return moduloRepository.save(entity);
	}

	@Override
	public Optional<Modulo> buscarId(Long id) {
		return moduloRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		moduloRepository.deleteById(id);
	}

	@Override
	public Modulo setDadosAtualizar(Long id, Modulo entity) {

		Optional<Modulo> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idModulo");
		return salvar(retorno.get());
	}
}
