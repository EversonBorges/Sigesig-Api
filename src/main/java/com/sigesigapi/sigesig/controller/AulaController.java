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
import com.sigesigapi.sigesig.model.Aula;
import com.sigesigapi.sigesig.serviceImpl.AulaServiceImpl;

@RestController
@RequestMapping("/aulas")
public class AulaController {
	
	@Autowired
	private  AulaServiceImpl aulaServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Aula> listar(){
		return aulaServiceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Aula> criar(@Valid @RequestBody Aula aula, HttpServletResponse response) {
		Aula aulaSalvo = aulaServiceImpl.salvar(aula);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, aulaSalvo.getIdAula()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(aulaSalvo);
	}
	
	@GetMapping("/{idAula}")
	public ResponseEntity<Aula> buscarId(@PathVariable Long idAula) {
		Optional<Aula> retorno = aulaServiceImpl.buscarId(idAula);
		
		return retorno.isPresent() ? new ResponseEntity<Aula>(retorno.get(),HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idAula}")
	public ResponseEntity<Aula> atualizar(@Valid @RequestBody Aula aula, 
			@PathVariable Long idAula){
		
		Aula aulaAlterado = aulaServiceImpl.setDadosAtualizar(idAula, aula);
		return new ResponseEntity<Aula>(aulaAlterado,HttpStatus.OK);
	}
	
	@DeleteMapping("/{idAula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idAula) {
		aulaServiceImpl.remover(idAula);     
	 }
}
