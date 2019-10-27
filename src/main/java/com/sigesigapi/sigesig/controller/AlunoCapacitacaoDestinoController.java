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
import com.sigesigapi.sigesig.model.AlunoCapacitacaoDestino;
import com.sigesigapi.sigesig.serviceImpl.AlunoCapacitacaoDestinoServiceImpl;

@RestController
@RequestMapping("/aluno_capacitacao_destino")
public class AlunoCapacitacaoDestinoController {

	@Autowired
	private AlunoCapacitacaoDestinoServiceImpl serviceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<AlunoCapacitacaoDestino> listar(Pageable pageable){
		return serviceImpl.listarTodos(pageable);
	}
	
	@PostMapping
	public ResponseEntity<AlunoCapacitacaoDestino> criar(@Valid @RequestBody AlunoCapacitacaoDestino alunoCapacitacaoDestino,
															HttpServletResponse response){
		AlunoCapacitacaoDestino alunoSalvo = serviceImpl.salvar(alunoCapacitacaoDestino);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, alunoSalvo.getIdAlunoCapacitacaoDestino()));
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
	}
	
	@GetMapping("/{idAluno}")
	public ResponseEntity<AlunoCapacitacaoDestino> buscarId(@PathVariable Long idAluno){
		
		Optional<AlunoCapacitacaoDestino> retorno = serviceImpl.buscarId(idAluno);
		return retorno.isPresent() ? new ResponseEntity<AlunoCapacitacaoDestino>(retorno.get(),HttpStatus.OK) :
						new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idAluno}")
	public ResponseEntity<AlunoCapacitacaoDestino> atualizar(@Valid @RequestBody AlunoCapacitacaoDestino alunoCapacitacaoDestino,
								@PathVariable Long idAluno){
		
		AlunoCapacitacaoDestino alunoAlterado = serviceImpl.setDadosAtualizar(idAluno, alunoCapacitacaoDestino);
		return new ResponseEntity<AlunoCapacitacaoDestino>(alunoAlterado,HttpStatus.OK);
	}
	
	@DeleteMapping("/{idAluno}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idAluno) {
		serviceImpl.remover(idAluno);
	}
}
