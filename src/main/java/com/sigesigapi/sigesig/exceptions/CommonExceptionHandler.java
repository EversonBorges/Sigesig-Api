package com.sigesigapi.sigesig.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemDev = ex.getCause().toString();
		List<Erro> listaErros = Arrays.asList(new Erro(mensagemUsuario, mensagemDev));
		return handleExceptionInternal(ex,listaErros , headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> listaErros = criarListaErros(ex.getBindingResult());
		return handleExceptionInternal(ex, listaErros, headers,  HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> criarListaErros(BindingResult result){
		List<Erro> erros = new ArrayList<>();
		for (FieldError erro : result.getFieldErrors()) {
			String mensagemUsuario = messageSource.getMessage(erro,LocaleContextHolder.getLocale());
			String mensagemDev = erro.toString();
			erros.add(new Erro(mensagemUsuario, mensagemDev));
		}
		
		return erros;
 	}
	
	private static class Erro {
		private String mensagemUsuario;
		private String mensagemDev;
		
		public Erro(String mensagemUsuario, String mensagemDev) {
			this.mensagemUsuario = mensagemUsuario;
			this.mensagemDev = mensagemDev;
		}

		public String getMensagemUsuario() {
			return mensagemUsuario;
		}

		public String getMensagemDev() {
			return mensagemDev;
		}
	}
}
