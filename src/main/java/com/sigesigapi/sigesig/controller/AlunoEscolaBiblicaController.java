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
import com.sigesigapi.sigesig.model.AlunoEscolaBiblica;
import com.sigesigapi.sigesig.serviceImpl.AlunoEscolaBiblicaServiceImpl;

@RestController
@RequestMapping("/aluno_escola_biblica")
public class AlunoEscolaBiblicaController {

	@Autowired
	private AlunoEscolaBiblicaServiceImpl serviceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<AlunoEscolaBiblica> listar(){
		return serviceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<AlunoEscolaBiblica> criar(@Valid @RequestBody AlunoEscolaBiblica alunoEscolaBiblica,HttpServletResponse response){
		
		AlunoEscolaBiblica alunoSalvo = serviceImpl.salvar(alunoEscolaBiblica);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, alunoSalvo.getIdAlunoEscolaBiblica()));
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
	}
	
	@GetMapping("/{idAluno}")
	public ResponseEntity<AlunoEscolaBiblica> buscarId(@PathVariable Long idAluno){
		
		Optional<AlunoEscolaBiblica> retorno = serviceImpl.buscarId(idAluno);
		return retorno.isPresent() ? new ResponseEntity<AlunoEscolaBiblica>(retorno.get(),HttpStatus.OK) :
						new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idAluno}")
	public ResponseEntity<AlunoEscolaBiblica> atualizar(@Valid @RequestBody AlunoEscolaBiblica alunoEscolaBiblica, 
															@PathVariable Long idAluno){
		
		AlunoEscolaBiblica alunoAtualizado = serviceImpl.setDadosAtualizar(idAluno, alunoEscolaBiblica);
		return new ResponseEntity<AlunoEscolaBiblica>(alunoAtualizado,HttpStatus.OK);
	}
	
	@DeleteMapping("/{idAluno}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idAluno) {
		serviceImpl.remover(idAluno);
	}
}
