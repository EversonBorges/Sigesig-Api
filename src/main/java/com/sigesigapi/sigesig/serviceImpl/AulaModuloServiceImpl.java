package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.AulaModulo;
import com.sigesigapi.sigesig.repository.AulaModuloRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class AulaModuloServiceImpl implements CommonService<AulaModulo>{

	@Autowired
	private AulaModuloRepository aulaModuloRepository;
	
	@Override
	public List<AulaModulo> listarTodos() {
		return aulaModuloRepository.findAll();
	}

	@Override
	public AulaModulo salvar(AulaModulo entity) {
		return aulaModuloRepository.save(entity);
	}

	@Override
	public Optional<AulaModulo> buscarId(Long id) {
		return aulaModuloRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		aulaModuloRepository.deleteById(id);
	}

	@Override
	public AulaModulo setDadosAtualizar(Long id, AulaModulo entity) {
		
		Optional<AulaModulo> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idAulaModulo");
		return aulaModuloRepository.save(retorno.get());
	}

}
