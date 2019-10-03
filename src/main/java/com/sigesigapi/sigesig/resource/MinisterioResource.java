package com.sigesigapi.sigesig.resource;

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
		
		Optional<Ministerio> retorno = ministerioServiceImpl.buscarId(idMinisterio);
		
		return retorno.isPresent() ? new ResponseEntity<Ministerio>(retorno.get(),HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idMinisterio}")
	public ResponseEntity<Ministerio> atualizar(@Valid @RequestBody Ministerio newMinisterio, @PathVariable("idMinisterio") Long idMinisterio){
		Optional<Ministerio> retorno = ministerioServiceImpl.buscarId(idMinisterio);
		
		if(retorno.isPresent()) {
			Ministerio ministerio= retorno.get();
			ministerio.setDescMinisterio(newMinisterio.getDescMinisterio());
			ministerioServiceImpl.salvar(ministerio);
			return new ResponseEntity<Ministerio>(ministerio,HttpStatus.OK);
		}else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{idMinisterio}")
	public ResponseEntity<?> deletar(@PathVariable("idMinisterio") Long idMinisterio) {
		
		Optional<Ministerio> retorno = ministerioServiceImpl.buscarId(idMinisterio);
	        if(retorno.isPresent()){
	        	ministerioServiceImpl.remover(retorno.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
