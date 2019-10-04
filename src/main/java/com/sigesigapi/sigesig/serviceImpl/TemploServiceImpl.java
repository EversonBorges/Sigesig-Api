package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Templo;
import com.sigesigapi.sigesig.repository.TemploRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class TemploServiceImpl implements CommonService<Templo>{

	@Autowired
	private TemploRepository temploRepository;
	
	@Override
	public List<Templo> listarTodos() {
		return temploRepository.findAll();
	}

	@Override
	public Templo salvar(Templo entity) {
		return temploRepository.save(entity);
	}

	@Override
	public Optional<Templo> buscarId(Long id) {
		return temploRepository.findById(id);
	}

	@Override
	public void remover(Templo entity) {
		temploRepository.delete(entity);
	}

	@Override
	public Templo setDadosAtualizar(Templo entity, Optional<Templo> retorno) {
		
		retorno.get().setCnpj(entity.getCnpj());
		retorno.get().setDtAbertura(entity.getDtAbertura());
		retorno.get().setNomeFantasia(entity.getNomeFantasia());
		retorno.get().setRazaoSocial(entity.getRazaoSocial());
		retorno.get().setTipo(entity.getTipo());
		
		temploRepository.save(retorno.get());
		return retorno.get();
	}

}
