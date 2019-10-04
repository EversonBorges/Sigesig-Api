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
		
		Membro membro = retorno.get();
		membro.setBatizado(entity.getBatizado());
		membro.setCapacitacaoConcluido(entity.getCapacitacaoConcluido());
		membro.setCpf(entity.getCpf());
		membro.setDtNasc(entity.getDtNasc());
		membro.setEndereco(membro.getEndereco());
		membro.setIdade(entity.getIdade());
		membro.setTurma(entity.getTurma());
		membro.setMatriculaEscolaBiblica(entity.getMatriculaEscolaBiblica());
		membro.setMatriculaLider(entity.getMatriculaLider());
		membro.setMinisterio(ministerio.get());
		membro.setNomeMembro(entity.getNomeMembro());
		membro.setRg(entity.getRg());
		membro.setSexo(entity.getSexo());
		membro.setTemplo(templo.get());
		membro.setTipo(entity.getTipo());
		membro.setTurma(entity.getTurma());
		membro.setEndereco(entity.getEndereco());
		membroRepository.save(membro);
		
		return membro;
	}
	
}
