package com.sigesigapi.sigesig.resource;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.sigesigapi.sigesig.event.RecursoCriadoEvent;
import com.sigesigapi.sigesig.model.Ministerio;
import com.sigesigapi.sigesig.serviceImpl.MinisterioServiceImpl;

@RestController
@RequestMapping("/ministerios")
public class MinisterioResource {
	
	@Autowired
	private  MinisterioServiceImpl ministerioServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Ministerio> listar(){
		return ministerioServiceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Ministerio> criar(@Valid @RequestBody Ministerio ministerio, HttpServletResponse response) {
		Ministerio ministerioSalvo = ministerioServiceImpl.salvar(ministerio);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ministerioSalvo.getIdMinisterio()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ministerioSalvo);
	}
	
	@GetMapping("/{idMinisterio}")
	public ResponseEntity<Ministerio> buscarId(@PathVariable("idMinisterio")Long idMinisterio) {
		
		Ministerio retorno = ministerioServiceImpl.buscarId(idMinisterio);
		
		return retorno != null ?  ResponseEntity.ok(retorno):
			ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{idMinisterio}")
	public ResponseEntity<Ministerio> atualizar(@Valid @RequestBody Ministerio ministerio, @PathVariable("idMinisterio") Long IdMinisterio){
		Ministerio retorno = ministerioServiceImpl.buscarId(IdMinisterio);
		
		retorno.setDescMinisterio(ministerio.getDescMinisterio());
		
		Ministerio retornoAtualizar = ministerioServiceImpl.salvar(retorno);
		
		return retorno != null ?  ResponseEntity.ok(retornoAtualizar):
			ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/idMinisterio")
	public ResponseEntity<?> deletar(@PathVariable("idMinisterio") Long idMinisterio) {
		
		Ministerio retorno = ministerioServiceImpl.buscarId(idMinisterio);
		ministerioServiceImpl.remover(retorno);
		
		return ResponseEntity.ok().build();
	}
}
