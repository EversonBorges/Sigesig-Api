package com.sigesigapi.sigesig.service;

import java.util.List;
import java.util.Optional;

public interface CommonService<T> {

	List<T> listarTodos();
	T salvar(T entity);
	Optional<T> buscarId(Long id);
	void remover(T entity);
	T setDadosAtualizar(T entity, Optional<T> retorno);
}
