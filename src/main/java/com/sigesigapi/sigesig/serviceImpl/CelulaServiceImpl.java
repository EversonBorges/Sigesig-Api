package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Celula;
import com.sigesigapi.sigesig.repository.CelulaRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class CelulaServiceImpl implements CommonService<Celula>{

	@Autowired
	private CelulaRepository celulaRepository;
	
	@Override
	public List<Celula> listarTodos() {
		return celulaRepository.findAll();
	}

	@Override
	public Celula salvar(Celula entity) {
		return celulaRepository.save(entity);
	}

	@Override
	public Optional<Celula> buscarId(Long id) {
		return celulaRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		celulaRepository.deleteById(id);
	}

	@Override
	public Celula setDadosAtualizar(Long id, Celula entity) {

		Optional<Celula> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idCelula");
		return celulaRepository.save(retorno.get());
	}

}
