package com.sigesigapi.sigesig.enums;

public enum Turmas {

	Adultos(0),
	Jovens(1),
	Adolescentes(2),
	Crianças(3);
	
	public int valorTurma;
	
	Turmas(int valor){
		valorTurma=valor;
	}
}
