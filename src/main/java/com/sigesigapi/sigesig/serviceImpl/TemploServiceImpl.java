package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Templo;
import com.sigesigapi.sigesig.repository.TemploRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class TemploServiceImpl implements CommonService<Templo>{

	@Autowired
	private TemploRepository temploRepository;
	
	@Autowired
	private TemploServiceImpl temploServiceImpl; 
	
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
	public void remover(Long id) {
		temploRepository.deleteById(id);
	}

	@Override
	public Templo setDadosAtualizar(Long idTemplo, Templo templo) {
		
		Optional<Templo> temploRetorno = temploServiceImpl.buscarId(idTemplo);
		if(!temploRetorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(templo, temploRetorno.get(), "idTemplo");
		return temploRepository.save(temploRetorno.get());
	}
}
