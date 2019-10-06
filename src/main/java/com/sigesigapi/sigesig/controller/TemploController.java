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
import com.sigesigapi.sigesig.model.Templo;
import com.sigesigapi.sigesig.serviceImpl.TemploServiceImpl;

@RestController
@RequestMapping("/templos")
public class TemploController {

	@Autowired
	private TemploServiceImpl temploServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Templo> listar(){
		return temploServiceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Templo> criar(@Valid @RequestBody Templo templo,HttpServletResponse response){
		Templo temploSalvo = temploServiceImpl.salvar(templo);
		publisher.publishEvent(new RecursoCriadoEvent(this,response,temploSalvo.getIdTemplo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(temploSalvo);
	}
	
	@GetMapping("/{idTemplo}")
	public ResponseEntity<Templo> buscarId(@PathVariable("idTemplo") Long idTemplo){
		Optional<Templo> retorno = temploServiceImpl.buscarId(idTemplo);
		
		return retorno.isPresent() ? new ResponseEntity<Templo>(retorno.get(),HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idTemplo}")
	public ResponseEntity<Templo> atualizar(@Valid @RequestBody Templo templo, 
									@PathVariable("idTemplo") Long idTemplo){
		
		Templo temploAtualizado = temploServiceImpl.setDadosAtualizar(idTemplo, templo);
		return new ResponseEntity<Templo>(temploAtualizado,HttpStatus.OK);
	}
	
	@DeleteMapping("/{idTemplo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable("idTemplo")Long idTemplo){
			temploServiceImpl.remover(idTemplo);
	}
}
