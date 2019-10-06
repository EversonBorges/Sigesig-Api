package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sigesigapi.sigesig.model.Ministerio;
import com.sigesigapi.sigesig.repository.MinisterioRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class MinisterioServiceImpl implements CommonService<Ministerio>{

	@Autowired
	private MinisterioRepository mr;
	
	@Autowired
	private MinisterioServiceImpl ministerioServiceImpl;
	
	@Override
	public List<Ministerio> listarTodos() {
		return mr.findAll();
	}

	@Override
	public Ministerio salvar(@RequestBody Ministerio ministerio) {
		return mr.save(ministerio);
	}

	@Override
	public Optional<Ministerio> buscarId(Long id) {
		return mr.findById(id);
	}

	@Override
	public void remover(Long id) {
		mr.deleteById(id);
	}

	@Override
	public Ministerio setDadosAtualizar(Long idMinisterio, Ministerio ministerio) {
		
		Optional<Ministerio> ministerioRetorno = ministerioServiceImpl.buscarId(idMinisterio);
		if(!ministerioRetorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(ministerio, ministerioRetorno.get(), "idMinisterio");
		return mr.save(ministerioRetorno.get());
	}
}
