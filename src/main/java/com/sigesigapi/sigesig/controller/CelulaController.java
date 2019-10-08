package com.sigesigapi.sigesig.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.sigesigapi.sigesig.model.Celula;
import com.sigesigapi.sigesig.serviceImpl.CelulaServiceImpl;

@RestController
@RequestMapping("/celula")
public class CelulaController {

	@Autowired
	private CelulaServiceImpl celulaServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Celula> listar(){
		return celulaServiceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Celula> criar(@Valid @RequestBody Celula celula, HttpServletResponse response){
		
		Celula celulaSalva = celulaServiceImpl.salvar(celula);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, celulaSalva.getIdCelula()));
		return ResponseEntity.status(HttpStatus.CREATED).body(celulaSalva);
	}
	
	@GetMapping("/{idCelula}")
	public ResponseEntity<Celula> buscarId(@PathVariable Long idCelula){
		
		Optional<Celula> retorno = celulaServiceImpl.buscarId(idCelula);
		return retorno.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(retorno.get()) :
						ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/{idCelula}")
	public ResponseEntity<Celula> atualizar(@Valid @RequestBody Celula celula,@PathVariable Long idCelula){
		Celula celulaAtualizada = celulaServiceImpl.setDadosAtualizar(idCelula, celula);
		return ResponseEntity.status(HttpStatus.OK).body(celulaAtualizada);
	}
	
	@DeleteMapping("/{idCelula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idCelula) {
		celulaServiceImpl.remover(idCelula);
	}
}
