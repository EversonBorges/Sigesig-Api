package com.sigesigapi.sigesig.service;

import java.util.List;

public interface CommonService<T> {

	List<T> listarTodos();
	T salvar(T entity);
	T buscarId(Long id);
	void remover(T entity);
}
