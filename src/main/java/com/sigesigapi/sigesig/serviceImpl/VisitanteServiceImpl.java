package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Membro;
import com.sigesigapi.sigesig.model.Templo;
import com.sigesigapi.sigesig.model.Visitante;
import com.sigesigapi.sigesig.repository.VisitanteRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class VisitanteServiceImpl implements CommonService<Visitante> {

	@Autowired
	private VisitanteRepository visitanteRepository;
	
	@Autowired
	private MembroServiceImpl membroServiceImpl;
	
	@Autowired
	private TemploServiceImpl temploServiceImpl;
	
	@Override
	public List<Visitante> listarTodos() {
		return visitanteRepository.findAll();
	}

	@Override
	public Visitante salvar(Visitante entity) {
		return visitanteRepository.save(entity);
	}

	@Override
	public Optional<Visitante> buscarId(Long id) {
		return visitanteRepository.findById(id);
	}

	@Override
	public void remover(Visitante entity) {
		visitanteRepository.delete(entity);
	}

	@Override
	public Visitante setDadosAtualizar(Visitante entity, Optional<Visitante> retorno) {
		
		Optional<Membro> membro = membroServiceImpl.buscarId(entity.getParenteDeQuem().getIdMembro());
		Optional<Templo> templo = temploServiceImpl.buscarId(entity.getTemplo().getIdTemplo());
		
		retorno.get().setDtNasc(entity.getDtNasc());
		retorno.get().setNomeVisitante(entity.getNomeVisitante());
		retorno.get().setParente(entity.getParente());
		retorno.get().setParenteDeQuem(entity.getParenteDeQuem());
		retorno.get().setParentesco(entity.getParentesco());
		retorno.get().setReligiao(entity.getReligiao());
		retorno.get().setRespoConvidar(membro.get());
		retorno.get().setSexo(entity.getSexo());
		retorno.get().setTemplo(templo.get());
		retorno.get().setVisitado(entity.getVisitado());
		
		visitanteRepository.save(retorno.get());
		return retorno.get();
	}

}
