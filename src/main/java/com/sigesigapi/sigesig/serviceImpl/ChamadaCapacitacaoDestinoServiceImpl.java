package com.sigesigapi.sigesig.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.ChamadaCapacitacaoDestino;
import com.sigesigapi.sigesig.repository.ChamadaCapacitacaoDestinoRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class ChamadaCapacitacaoDestinoServiceImpl implements CommonService<ChamadaCapacitacaoDestino>{

	@Autowired
	private ChamadaCapacitacaoDestinoRepository chamadaCapacitacaoDestinoRepository;
	
	@Override
	public Page<ChamadaCapacitacaoDestino> listarTodos(Pageable pageable) {
		return chamadaCapacitacaoDestinoRepository.findAll(pageable);
	}

	@Override
	public ChamadaCapacitacaoDestino salvar(ChamadaCapacitacaoDestino entity) {
		return chamadaCapacitacaoDestinoRepository.save(entity);
	}

	@Override
	public Optional<ChamadaCapacitacaoDestino> buscarId(Long id) {
		return chamadaCapacitacaoDestinoRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		chamadaCapacitacaoDestinoRepository.deleteById(id);
	}

	@Override
	public ChamadaCapacitacaoDestino setDadosAtualizar(Long id, ChamadaCapacitacaoDestino entity) {

		Optional<ChamadaCapacitacaoDestino> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idChamadaCapacitacaoDestino");
		return chamadaCapacitacaoDestinoRepository.save(retorno.get());
	}

}
