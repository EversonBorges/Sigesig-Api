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
import com.sigesigapi.sigesig.model.Entradas;
import com.sigesigapi.sigesig.serviceImpl.EntradaServiceImpl;

@RestController
@RequestMapping("/entradas")
public class EntradasController {

	@Autowired
	private EntradaServiceImpl entradaServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Entradas> listar(){
		return entradaServiceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Entradas> criar(@Valid @RequestBody Entradas entradas,HttpServletResponse response){
		
		Entradas entradasSalva = entradaServiceImpl.salvar(entradas);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, entradasSalva.getIdEntrada()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entradasSalva);
	}
	
	@GetMapping("/{idEntrada}")
	public ResponseEntity<Entradas> buscarId(@PathVariable Long idEntrada){
		Optional<Entradas> retorno = entradaServiceImpl.buscarId(idEntrada);
		return retorno.isPresent() ? new ResponseEntity<Entradas>(retorno.get(),HttpStatus.OK):
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idEntrada}")
	public ResponseEntity<Entradas> atualizar(@Valid @RequestBody Entradas entradas, @PathVariable Long idEntrada){
		
		Entradas entradaAlterada = entradaServiceImpl.setDadosAtualizar(idEntrada, entradas);
		return new ResponseEntity<Entradas>(entradaAlterada,HttpStatus.OK);
	}
	
	@DeleteMapping("/{idEntrada}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idEntrada) {
		entradaServiceImpl.remover(idEntrada);
	}
}
