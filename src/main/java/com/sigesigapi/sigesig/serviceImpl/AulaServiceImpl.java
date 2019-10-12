package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Aula;
import com.sigesigapi.sigesig.repository.AulaRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class AulaServiceImpl implements CommonService<Aula>{

	@Autowired
	private AulaRepository aulaRepository;
	
	@Override
	public List<Aula> listarTodos() {
		return aulaRepository.findAll();
	}

	@Override
	public Aula salvar(Aula entity) {
		return aulaRepository.save(entity);
	}

	@Override
	public Optional<Aula> buscarId(Long id) {
		return aulaRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		aulaRepository.deleteById(id);
	}

	@Override
	public Aula setDadosAtualizar(Long id, Aula aula) {
		Optional<Aula> aulaRetorno = buscarId(id);
		if(!aulaRetorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(aula, aulaRetorno.get(), "idAula");
		return aulaRepository.save(aulaRetorno.get());	}

	
}
