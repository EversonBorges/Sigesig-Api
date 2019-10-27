package com.sigesigapi.sigesig.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.enums.Turmas;
import com.sigesigapi.sigesig.model.Membro;
import com.sigesigapi.sigesig.repository.MembroRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class MembroServiceImpl implements CommonService<Membro>{

	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private  MembroServiceImpl membroServiceImpl;
	
	public Page<Membro> listarTodos(Pageable pageable) {
		return membroRepository.findAll(pageable);
	}

	@Override
	public Membro salvar(Membro membro) {
		
		if (membro.getIdade() <=7 ) {
			membro.setTurma(Turmas.Crianças);
			
		}else if(membro.getIdade() >7 && membro.getIdade() <=15   ) {
			membro.setTurma(Turmas.Adolescentes);
		}
		else if(membro.getIdade() >15 && membro.getIdade() <=25   ) {
			membro.setTurma(Turmas.Jovens);
		}else {
			membro.setTurma(Turmas.Adultos);
		}
		
		return membroRepository.save(membro);
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

	public Membro atualizarStatus(Long idMembro, Boolean tipo) {
		
		Optional<Membro> membroRetorno = buscarMembro(idMembro);
		membroRetorno.get().setAtivo(tipo);
		return membroRepository.save(membroRetorno.get());
	}
	
	private Optional<Membro> buscarMembro(Long idMembro) {
		Optional<Membro> membroRetorno = membroServiceImpl.buscarId(idMembro);
		if(!membroRetorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return membroRetorno;
	}
}
