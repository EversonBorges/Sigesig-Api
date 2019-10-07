package com.sigesigapi.sigesig.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sigesigapi.sigesig.model.AlunoEscolaBiblica;
import com.sigesigapi.sigesig.repository.AlunoEscolaBiblicaRepository;
import com.sigesigapi.sigesig.service.CommonService;

@Service
public class AlunoEscolaBiblicaServiceImpl implements CommonService<AlunoEscolaBiblica>{

	@Autowired
	private AlunoEscolaBiblicaRepository alunoEscolaBiblicaRepository;
	
	@Override
	public List<AlunoEscolaBiblica> listarTodos() {
		return alunoEscolaBiblicaRepository.findAll();
	}

	@Override
	public AlunoEscolaBiblica salvar(AlunoEscolaBiblica entity) {
		return alunoEscolaBiblicaRepository.save(entity);
	}

	@Override
	public Optional<AlunoEscolaBiblica> buscarId(Long id) {
		return alunoEscolaBiblicaRepository.findById(id);
	}

	@Override
	public void remover(Long id) {
		alunoEscolaBiblicaRepository.deleteById(id);
	}

	@Override
	public AlunoEscolaBiblica setDadosAtualizar(Long id, AlunoEscolaBiblica entity) {
		
		Optional<AlunoEscolaBiblica> retorno = buscarId(id);
		if(!retorno.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, retorno.get(), "idAlunoEscolaBiblica");
		return alunoEscolaBiblicaRepository.save(retorno.get());
	}

}
