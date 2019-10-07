package com.sigesigapi.sigesig.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigesigapi.sigesig.event.RecursoCriadoEvent;
import com.sigesigapi.sigesig.model.EscolaBiblica;
import com.sigesigapi.sigesig.serviceImpl.EscolaBiblicaServiceImpl;

@RestController
@RequestMapping("/escola_biblica")
public class EscolaBiblicaController {
	
	@Autowired
	private EscolaBiblicaServiceImpl escolaBiblicaServiceImpl;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<EscolaBiblica> listar(){
		return escolaBiblicaServiceImpl.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<EscolaBiblica> criar(@Valid @RequestBody EscolaBiblica escolaBiblica, HttpServletResponse response){
		
		EscolaBiblica escolaSalva = escolaBiblicaServiceImpl.salvar(escolaBiblica);
		publisher.publishEvent(new RecursoCriadoEvent(this,response,escolaSalva.getIdEscolaBiblica()));
		return ResponseEntity.status(HttpStatus.CREATED).body(escolaSalva);
	}
	
	@GetMapping("/{idEscolaBiblica}")
	public ResponseEntity<EscolaBiblica> buscarId(@PathVariable Long idEscolaBiblica){
		
		Optional<EscolaBiblica> escolaRetorno = escolaBiblicaServiceImpl.buscarId(idEscolaBiblica);
		return escolaRetorno.isPresent() ? new ResponseEntity<EscolaBiblica>(escolaRetorno.get(),HttpStatus.OK) :
							new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{idEscolaBiblica}")
	public ResponseEntity<EscolaBiblica> atualizar(@Valid @RequestBody EscolaBiblica escolaBiblica, @PathVariable Long idEscolaBiblica){
		
		EscolaBiblica escolaAlterada = escolaBiblicaServiceImpl.setDadosAtualizar(idEscolaBiblica, escolaBiblica);
		return new ResponseEntity<EscolaBiblica>(escolaAlterada,HttpStatus.OK);
	}
	
	@PutMapping("/{idEscolaBiblica}/ativo")
	public ResponseEntity<EscolaBiblica> atualizarStatus(@PathVariable Long idEscolaBiblica,@RequestBody Boolean ativo){
		
		EscolaBiblica escolaRetorno = escolaBiblicaServiceImpl.atualizarStatus(idEscolaBiblica,ativo);
		return new ResponseEntity<EscolaBiblica>(escolaRetorno,HttpStatus.OK);
	}
}
