package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.ModuloCapacitacaoDestino;
import com.sigesigapi.sigesig.repository.ModuloCapacitacaoDestinoRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class ModuloCapacitacaoDestinoServiceImpl implements CommonService<ModuloCapacitacaoDestino>{

	@Autowired
	private ModuloCapacitacaoDestinoRepository moduloCapacitacaoDestinoRepository;
	
	@Override
	public List<ModuloCapacitacaoDestino> listarTodos() {
		return moduloCapacitacaoDestinoRepository.findAll();
	}

	@Override
	public ModuloCapacitacaoDestino salvar(ModuloCapacitacaoDestino entity) {
		return moduloCapacitacaoDestinoRepository.save(entity);
	}

	@Override
	public Optional<ModuloCapacitacaoDestino> buscarId(Long id) {
		return moduloCapacitacaoDestinoRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		moduloCapacitacaoDestinoRepository.deleteById(id);
	}

	@Override
	public ModuloCapacitacaoDestino setDadosAtualizar(Long id, ModuloCapacitacaoDestino entity) {

		Optional<ModuloCapacitacaoDestino> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idModuloCapacitacaoDestino");
		return moduloCapacitacaoDestinoRepository.save(retorno.get());
	}

}
