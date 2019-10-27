package com.sigesigapi.sigesig.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.ParticipanteCelula;
import com.sigesigapi.sigesig.repository.ParticipanteCelulaRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class ParticipanteCelulaServiceImpl implements CommonService<ParticipanteCelula>{

	@Autowired
	private ParticipanteCelulaRepository participanteCelulaRepository;
	
	@Override
	public Page<ParticipanteCelula> listarTodos(Pageable pageable) {
		return participanteCelulaRepository.findAll(pageable);
	}

	@Override
	public ParticipanteCelula salvar(ParticipanteCelula entity) {
		return participanteCelulaRepository.save(entity);
	}

	@Override
	public Optional<ParticipanteCelula> buscarId(Long id) {
		return participanteCelulaRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		participanteCelulaRepository.deleteById(id);
	}

	@Override
	public ParticipanteCelula setDadosAtualizar(Long id, ParticipanteCelula entity) {

		Optional<ParticipanteCelula> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idParticipante");
		return salvar(retorno.get());
	}

}
