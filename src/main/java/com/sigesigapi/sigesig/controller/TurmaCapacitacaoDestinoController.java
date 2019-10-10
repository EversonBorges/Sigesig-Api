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
import com.sigesigapi.sigesig.model.TurmaCapacitacaoDestino;
import com.sigesigapi.sigesig.serviceImpl.TurmaCapacitacaoDestinoServiceImpl;

@RestController
@RequestMapping("/turma_capacitacao_destino")
public class TurmaCapacitacaoDestinoController {

	@Autowired
	private TurmaCapacitacaoDestinoServiceImpl serviceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<TurmaCapacitacaoDestino> listar(){
		
		return serviceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<TurmaCapacitacaoDestino> criar(@Valid @RequestBody TurmaCapacitacaoDestino turmaCapacitacaoDestino,
						HttpServletResponse response){
		
		TurmaCapacitacaoDestino turmaSalva = serviceImpl.salvar(turmaCapacitacaoDestino);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, turmaSalva.getIdTurmaCapacitacaoDestino()));
		return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalva);
	}
	
	@GetMapping("/idTurma")
	public ResponseEntity<TurmaCapacitacaoDestino> buscarId(@PathVariable Long idTurma){
		
		Optional<TurmaCapacitacaoDestino> retorno = serviceImpl.buscarId(idTurma);
		return retorno.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(retorno.get()) :
								ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/{idTurma}")
	public ResponseEntity<TurmaCapacitacaoDestino> atualizar(@Valid @RequestBody TurmaCapacitacaoDestino turmaCapacitacaoDestino,
								@PathVariable Long idTurma){
		
		TurmaCapacitacaoDestino turmaAlterada = serviceImpl.setDadosAtualizar(idTurma, turmaCapacitacaoDestino);
		return ResponseEntity.ok().body(turmaAlterada);
	}
	
	@DeleteMapping("/{idTurma}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idTurma) {
		serviceImpl.remover(idTurma);
	}
}
