package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sigesigapi.sigesig.model.Membros;
import com.sigesigapi.sigesig.repository.MembroRepository;
import com.sigesigapi.sigesig.service.CommonService;

public class MembrosServiceImpl implements CommonService<Membros>{

	@Autowired
	private MembroRepository membroRepository;
	
	@Override
	public List<Membros> listarTodos() {
		return membroRepository.findAll();
	}

	@Override
	public Membros salvar(Membros entity) {
		return membroRepository.save(entity);
	}

	@Override
	public Optional<Membros> buscarId(Long id) {
		return membroRepository.findById(id);
	}

	@Override
	public void remover(Membros entity) {
		membroRepository.delete(entity);
	}
	
}
