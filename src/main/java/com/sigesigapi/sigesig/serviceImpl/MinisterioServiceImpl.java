package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sigesigapi.sigesig.model.Ministerio;
import com.sigesigapi.sigesig.repository.MinisterioRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class MinisterioServiceImpl implements CommonService<Ministerio>{

	@Autowired
	private MinisterioRepository mr;
	
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
	public void remover(Ministerio entity) {
		mr.delete(entity);
	}

	@Override
	public Ministerio setDadosAtualizar(Ministerio newMinisterio, Optional<Ministerio> retorno) {
		Ministerio ministerio= retorno.get();
		ministerio.setDescMinisterio(newMinisterio.getDescMinisterio());
		mr.save(ministerio);
		return ministerio;
	}
}
