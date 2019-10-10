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
import com.sigesigapi.sigesig.model.ModuloCapacitacaoDestino;
import com.sigesigapi.sigesig.serviceImpl.ModuloCapacitacaoDestinoServiceImpl;

@RestController
@RequestMapping("/modulo_capacitacao_destino")
public class ModuloCapacitacaoDestinoController {

	@Autowired
	private ModuloCapacitacaoDestinoServiceImpl serviceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<ModuloCapacitacaoDestino> listar(){
		return serviceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<ModuloCapacitacaoDestino> criar(@Valid @RequestBody ModuloCapacitacaoDestino capacitacaoDestino,
							HttpServletResponse response){
		
		ModuloCapacitacaoDestino moduloSalvo = serviceImpl.salvar(capacitacaoDestino);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, moduloSalvo.getIdModuloCapacitacaoDestino()));
		return ResponseEntity.status(HttpStatus.CREATED).body(moduloSalvo);
	}
	
	@GetMapping("/{idModulo}")
	public ResponseEntity<ModuloCapacitacaoDestino> buscarId(@PathVariable Long idModulo){
		
		Optional<ModuloCapacitacaoDestino> retorno = serviceImpl.buscarId(idModulo);
		return retorno.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(retorno.get()) :
						ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/{idModulo}")
	public ResponseEntity<ModuloCapacitacaoDestino> atualizar(@Valid @RequestBody ModuloCapacitacaoDestino capacitacaoDestino,
			@PathVariable Long idModulo){
		
		ModuloCapacitacaoDestino moduloAlterado = serviceImpl.setDadosAtualizar(idModulo, capacitacaoDestino);
		return ResponseEntity.status(HttpStatus.OK).body(moduloAlterado);
	}
	
	@DeleteMapping("/{idModulo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idModulo) {
		
		serviceImpl.remover(idModulo);
	}
}
