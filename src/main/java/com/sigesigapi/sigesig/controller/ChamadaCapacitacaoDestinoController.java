package com.sigesigapi.sigesig.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.sigesigapi.sigesig.model.ChamadaCapacitacaoDestino;
import com.sigesigapi.sigesig.serviceImpl.ChamadaCapacitacaoDestinoServiceImpl;

@RestController
@RequestMapping("/chamada_capacitacao_destino")
public class ChamadaCapacitacaoDestinoController {

	@Autowired
	private ChamadaCapacitacaoDestinoServiceImpl serviceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<ChamadaCapacitacaoDestino> listar(Pageable pageable){
		return serviceImpl.listarTodos(pageable);
	}
	
	@PostMapping
	public ResponseEntity<ChamadaCapacitacaoDestino> criar(@Valid @RequestBody ChamadaCapacitacaoDestino capacitacaoDestino,
						HttpServletResponse response){
		
		ChamadaCapacitacaoDestino chamadaSalva = serviceImpl.salvar(capacitacaoDestino);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, chamadaSalva.getIdChamadaCapacitacaoDestino()));
		return ResponseEntity.status(HttpStatus.CREATED).body(chamadaSalva);
	}
	
	@GetMapping("/{idChamada}")
	public ResponseEntity<ChamadaCapacitacaoDestino> buscarId(@PathVariable Long idChamada){
		
		Optional<ChamadaCapacitacaoDestino> retorno = serviceImpl.buscarId(idChamada);
		return retorno.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(retorno.get()) :
			       ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/{idChamada}")
	public ResponseEntity<ChamadaCapacitacaoDestino> atualizar(@Valid @RequestBody ChamadaCapacitacaoDestino capacitacaoDestino,
									@PathVariable Long idChamada){
		
		ChamadaCapacitacaoDestino chamadaAlterada = serviceImpl.setDadosAtualizar(idChamada, capacitacaoDestino);
		return ResponseEntity.status(HttpStatus.OK).body(chamadaAlterada);
	}
	
	@DeleteMapping("/{idChamada}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idChamada) {
		serviceImpl.remover(idChamada);
	}
}
