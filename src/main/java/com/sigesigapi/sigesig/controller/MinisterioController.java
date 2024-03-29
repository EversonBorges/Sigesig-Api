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
import com.sigesigapi.sigesig.model.Ministerio;
import com.sigesigapi.sigesig.serviceImpl.MinisterioServiceImpl;

@RestController
@RequestMapping("/ministerios")
public class MinisterioController {
	
	@Autowired
	private  MinisterioServiceImpl ministerioServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<Ministerio> listar(Pageable pageable){
		return ministerioServiceImpl.listarTodos(pageable);
	}
	
	@PostMapping
	public ResponseEntity<Ministerio> criar(@Valid @RequestBody Ministerio ministerio, HttpServletResponse response) {
		Ministerio ministerioSalvo = ministerioServiceImpl.salvar(ministerio);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ministerioSalvo.getIdMinisterio()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ministerioSalvo);
	}
	
	@GetMapping("/{idMinisterio}")
	public ResponseEntity<Ministerio> buscarId(@PathVariable("idMinisterio")Long idMinisterio) {
		Optional<Ministerio> retorno = ministerioServiceImpl.buscarId(idMinisterio);
		
		return retorno.isPresent() ? new ResponseEntity<Ministerio>(retorno.get(),HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idMinisterio}")
	public ResponseEntity<Ministerio> atualizar(@Valid @RequestBody Ministerio ministerio, 
			@PathVariable Long idMinisterio){
		
		Ministerio ministerioAlterado = ministerioServiceImpl.setDadosAtualizar(idMinisterio, ministerio);
		return new ResponseEntity<Ministerio>(ministerioAlterado,HttpStatus.OK);
	}
	
	@DeleteMapping("/{idMinisterio}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idMinisterio) {
		ministerioServiceImpl.remover(idMinisterio);     
	 }
}
