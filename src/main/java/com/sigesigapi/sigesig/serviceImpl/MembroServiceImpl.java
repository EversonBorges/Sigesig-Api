package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.Membro;
import com.sigesigapi.sigesig.repository.MembroRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class MembroServiceImpl implements CommonService<Membro>{

	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private  MembroServiceImpl membroServiceImpl;
	
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
	public void remover(Long id) {
		membroRepository.deleteById(id);
	}

	@Override
	public Membro setDadosAtualizar(Long idMembro, Membro membro) {
		
		Optional<Membro> membroRetorno = buscarMembro(idMembro);
		BeanUtils.copyProperties(membro, membroRetorno.get(), "idMembro");
		return membroRepository.save(membroRetorno.get());
	}

	public void atualizarPropriedadeTipo(Long idMembro, Boolean tipo) {
		
		Optional<Membro> membroRetorno = buscarMembro(idMembro);
		membroRetorno.get().setTipo(tipo);
		membroRepository.save(membroRetorno.get());
	}
	
	private Optional<Membro> buscarMembro(Long idMembro) {
		Optional<Membro> membroRetorno = membroServiceImpl.buscarId(idMembro);
		if(!membroRetorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return membroRetorno;
	}
}
