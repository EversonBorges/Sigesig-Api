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
import com.sigesigapi.sigesig.model.ParticipanteCelula;
import com.sigesigapi.sigesig.serviceImpl.ParticipanteCelulaServiceImpl;

@RestController
@RequestMapping("/participante_celula")
public class ParticipanteCelulaController {

	@Autowired
	private ParticipanteCelulaServiceImpl serviceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<ParticipanteCelula> listar(){
		
		return serviceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<ParticipanteCelula> criar(@Valid @RequestBody ParticipanteCelula participanteCelula,
							HttpServletResponse response){
		
		ParticipanteCelula participanteCelulaSalvo = serviceImpl.salvar(participanteCelula);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, participanteCelulaSalvo.getIdParticipante()));
		return ResponseEntity.status(HttpStatus.CREATED).body(participanteCelulaSalvo);
	}
	
	@GetMapping("/{idParticipante}")
	public ResponseEntity<ParticipanteCelula> buscarId(@PathVariable Long idParticipante){
		
		Optional<ParticipanteCelula> retorno  = serviceImpl.buscarId(idParticipante);
		return ResponseEntity.status(HttpStatus.OK).body(retorno.get());
	}
	
	@PutMapping("/{idParticipante}")
	public ResponseEntity<ParticipanteCelula> atualizar(@Valid @RequestBody ParticipanteCelula participanteCelula,
							@PathVariable Long idParticipante){
		
		ParticipanteCelula participanteCelulaAlterado  = serviceImpl.setDadosAtualizar(idParticipante, participanteCelula);
		return ResponseEntity.status(HttpStatus.OK).body(participanteCelulaAlterado);
	}
	
	@DeleteMapping("/{idParticipante}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idVisitante) {
		
		serviceImpl.remover(idVisitante);
	}
}