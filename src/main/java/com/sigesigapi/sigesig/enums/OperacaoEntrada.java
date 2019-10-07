package com.sigesigapi.sigesig.enums;

public enum OperacaoEntrada {

	DIZIMO(1),
	OFERTA(2),
	MISSAO(3),
	VOTO(4);
	
	public int valorOperacao;
	
	private OperacaoEntrada(int valor) {
		valorOperacao=valor;
	}

}
