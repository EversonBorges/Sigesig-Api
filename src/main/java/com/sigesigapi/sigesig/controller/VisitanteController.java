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
import com.sigesigapi.sigesig.model.Visitante;
import com.sigesigapi.sigesig.serviceImpl.VisitanteServiceImpl;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

	@Autowired
	private VisitanteServiceImpl visitanteServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<Visitante> listar(Pageable pageable){
		return visitanteServiceImpl.listarTodos(pageable);
	}
	
	@PostMapping
	public ResponseEntity<Visitante> criar(@Valid @RequestBody Visitante visitante,HttpServletResponse response){
		Visitante visitanteSalvo = visitanteServiceImpl.salvar(visitante);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, visitanteSalvo.getIdVisitante()));
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{idVisitante}")
	public ResponseEntity<Visitante> buscarId(@PathVariable("idVisitante") Long idVisitante){
		Optional<Visitante> retorno = visitanteServiceImpl.buscarId(idVisitante);
		
		return retorno.isPresent() ? new ResponseEntity<Visitante>(retorno.get(),HttpStatus.OK) :
								new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idVisitante}")
	public ResponseEntity<Visitante> atualizar(@Valid @RequestBody Visitante visitante, 
					@PathVariable("idVisitante") Long idVisitante){
		Visitante visitanteAlterado = visitanteServiceImpl.setDadosAtualizar(idVisitante, visitante);
		return new ResponseEntity<Visitante>(visitanteAlterado,HttpStatus.OK);
	}
	
	@DeleteMapping("/{idVisitante}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idVisitante){
		visitanteServiceImpl.remover(idVisitante);
	}
}
