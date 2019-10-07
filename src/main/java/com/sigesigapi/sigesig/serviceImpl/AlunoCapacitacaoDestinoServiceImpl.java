package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.AlunoCapacitacaoDestino;
import com.sigesigapi.sigesig.repository.AlunosCapacitacaoDestinoRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class AlunoCapacitacaoDestinoServiceImpl implements CommonService<AlunoCapacitacaoDestino>{

	@Autowired
	private AlunosCapacitacaoDestinoRepository alunosCapacitacaoDestinoRepository;
	
	@Override
	public List<AlunoCapacitacaoDestino> listarTodos() {
		return alunosCapacitacaoDestinoRepository.findAll();
	}

	@Override
	public AlunoCapacitacaoDestino salvar(AlunoCapacitacaoDestino entity) {
		return alunosCapacitacaoDestinoRepository.save(entity);
	}

	@Override
	public Optional<AlunoCapacitacaoDestino> buscarId(Long id) {
		return alunosCapacitacaoDestinoRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		alunosCapacitacaoDestinoRepository.deleteById(id);
	}

	@Override
	public AlunoCapacitacaoDestino setDadosAtualizar(Long id, AlunoCapacitacaoDestino entity) {

		Optional<AlunoCapacitacaoDestino> retorno = this.buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idAlunoCapacitacaoDestino");
		return alunosCapacitacaoDestinoRepository.save(retorno.get());
	}

}
