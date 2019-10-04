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
import org.springframework.web.bind.annotation.RestController;

import com.sigesigapi.sigesig.event.RecursoCriadoEvent;
import com.sigesigapi.sigesig.model.Membro;
import com.sigesigapi.sigesig.serviceImpl.MembroServiceImpl;

@RestController
@RequestMapping("/membros")
public class MembroController {
	
	@Autowired
	private MembroServiceImpl membroServiceImpl; 
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Membro> listar(){
		return membroServiceImpl.listarTodos();
	}

	@PostMapping
	public ResponseEntity<Membro> criar(@Valid @RequestBody Membro membro,HttpServletResponse response){
		
		Membro membroSalvo = membroServiceImpl.salvar(membro);
		publisher.publishEvent(new RecursoCriadoEvent(this,response,membroSalvo.getIdMembro()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(membroSalvo);
	}
	
	@GetMapping("/{idMembro}")
	public ResponseEntity<Membro> buscarId(@PathVariable("idMembro") Long idMembro){
		
		Optional<Membro> retorno = membroServiceImpl.buscarId(idMembro);
		
		return retorno.isPresent() ? new ResponseEntity<Membro>(retorno.get(),HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idMembro}")
	public ResponseEntity<Membro> atualizar(@PathVariable("idMembro") Long idMembro, @Valid @RequestBody Membro newMembro){
		Optional<Membro> retorno = membroServiceImpl.buscarId(idMembro);
		
		if(retorno.isPresent()) {
			Membro membro = membroServiceImpl.setDadosAtualizar(newMembro, retorno);
			return new ResponseEntity<Membro>(membro,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{idMembro}")
	public ResponseEntity<?> deletar(@PathVariable("idMembro")Long idMembro){
		
		Optional<Membro> retorno = membroServiceImpl.buscarId(idMembro);
		
		if(retorno.isPresent()) {
			membroServiceImpl.remover(retorno.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
