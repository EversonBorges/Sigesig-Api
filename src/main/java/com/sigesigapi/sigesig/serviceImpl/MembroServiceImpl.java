package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Membro;
import com.sigesigapi.sigesig.model.Ministerio;
import com.sigesigapi.sigesig.model.Templo;
import com.sigesigapi.sigesig.repository.MembroRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class MembroServiceImpl implements CommonService<Membro>{

	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private MinisterioServiceImpl ministerioServiceImpl;
	
	@Autowired
	private TemploServiceImpl temploServiceImpl;
	
	@Override
	public List<Membro> listarTodos() {
		return membroRepository.findAll();
	}

	@Override
	public Membro salvar(Membro entity) {
		return membroRepository.save(entity);
	}

	@Override
	public Optional<Membro> buscarId(Long id) {
		return membroRepository.findById(id);
	}

	@Override
	public void remover(Membro entity) {
		membroRepository.delete(entity);
	}

	@Override
	public Membro setDadosAtualizar(Membro entity, Optional<Membro> retorno) {
		Optional<Ministerio> ministerio = ministerioServiceImpl.buscarId(entity.getMinisterio().getIdMinisterio());
		Optional<Templo> templo = temploServiceImpl.buscarId(entity.getTemplo().getIdTemplo());
		
		retorno.get().setBatizado(entity.getBatizado());
		retorno.get().setCapacitacaoConcluido(entity.getCapacitacaoConcluido());
		retorno.get().setCpf(entity.getCpf());
		retorno.get().setDtNasc(entity.getDtNasc());
		retorno.get().setEndereco(retorno.get().getEndereco());
		retorno.get().setIdade(entity.getIdade());
		retorno.get().setTurma(entity.getTurma());
		retorno.get().setMatriculaEscolaBiblica(entity.getMatriculaEscolaBiblica());
		retorno.get().setMatriculaLider(entity.getMatriculaLider());
		retorno.get().setMinisterio(ministerio.get());
		retorno.get().setNomeMembro(entity.getNomeMembro());
		retorno.get().setRg(entity.getRg());
		retorno.get().setSexo(entity.getSexo());
		retorno.get().setTemplo(templo.get());
		retorno.get().setTipo(entity.getTipo());
		retorno.get().setTurma(entity.getTurma());
		retorno.get().setEndereco(entity.getEndereco());
		membroRepository.save(retorno.get());
		
		return retorno.get();
	}
	
}
