package com.sigesigapi.sigesig.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sigesigapi.sigesig.event.RecursoCriadoEvent;
import com.sigesigapi.sigesig.model.Modulo;
import com.sigesigapi.sigesig.serviceImpl.ModuloServiceImpl;

@RestController
@RequestMapping("/modulo")
public class ModuloController {

	@Autowired
	private ModuloServiceImpl moduloServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<Modulo> listar(Pageable pageable){
		return moduloServiceImpl.listarTodos(pageable);
	}
	
	@PostMapping
	public ResponseEntity<Modulo> criar(@Valid @RequestBody Modulo modulo, HttpServletResponse response){
		
		Modulo moduloSalvo = moduloServiceImpl.salvar(modulo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, moduloSalvo.getIdModulo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(moduloSalvo);
	}
	
	@GetMapping("/{idModulo}")
	public ResponseEntity<Modulo> buscarId(@PathVariable Long idModulo){
		
		Optional<Modulo> retorno = moduloServiceImpl.buscarId(idModulo);
		return retorno.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(retorno.get()) :
								ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/{idModulo}")
	public ResponseEntity<Modulo> atualizar(@Valid @RequestBody Modulo modulo, @PathVariable Long idModulo){
		
		Modulo moduloAtualizado = moduloServiceImpl.setDadosAtualizar(idModulo, modulo);
		return ResponseEntity.status(HttpStatus.OK).body(moduloAtualizado);
	}
	
	@DeleteMapping("/{idModulo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idModulo) {
		
		moduloServiceImpl.remover(idModulo);
	}
}
