package com.sigesigapi.sigesig.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonService<T> {

	Page<T> listarTodos(Pageable pageable);
	T salvar(T entity);
	Optional<T> buscarId(Long id);
	void remover(Long id);
	T setDadosAtualizar(Long id,T entity);
}
