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
import com.sigesigapi.sigesig.model.AulaModulo;
import com.sigesigapi.sigesig.serviceImpl.AulaModuloServiceImpl;

@RestController
@RequestMapping("/aula_modulo")
public class AulaModuloController {

	@Autowired
	private AulaModuloServiceImpl serviceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<AulaModulo> listar(){
		return serviceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<AulaModulo> criar(@Valid @RequestBody AulaModulo aulaModulo, HttpServletResponse response){
		
		AulaModulo aulaModuloSalvo = serviceImpl.salvar(aulaModulo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, aulaModuloSalvo.getIdAulaModulo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(aulaModuloSalvo);
	}
	
	@GetMapping("/{idAulaModulo}")
	public ResponseEntity<AulaModulo> buscarId(@PathVariable Long idAulaModulo){
		
		Optional<AulaModulo> retorno = serviceImpl.buscarId(idAulaModulo);
		return retorno.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(retorno.get()) : 
				ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/{idAulaModulo}")
	public ResponseEntity<AulaModulo> atualizar(@Valid @RequestBody AulaModulo aulaModulo, @PathVariable Long idAulaModulo){
		
		AulaModulo aulaModulaAtualizada = serviceImpl.setDadosAtualizar(idAulaModulo, aulaModulo);
		return ResponseEntity.status(HttpStatus.OK).body(aulaModulaAtualizada);
	}
	
	@DeleteMapping("/{idAulaModulo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idAulaModulo) {
		serviceImpl.remover(idAulaModulo);
	}
}

