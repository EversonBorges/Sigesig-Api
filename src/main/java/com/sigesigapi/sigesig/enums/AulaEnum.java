package com.sigesigapi.sigesig.enums;

import java.util.ArrayList;
import java.util.List;

public enum AulaEnum {

	Aula_01("Aula 1",1),
	Aula_02("Aula 2",2),
	Aula_03("Aula 3",3),
	Aula_04("Aula 4",4),
	Aula_05("Aula 5",5),
	Aula_06("Aula 6",6),
	Aula_07("Aula 7",7),
	Aula_08("Aula 8",8),
	Aula_09("Aula 9",9),
	Aula_10("Aula 10",10);
	
	
private int valorAula;
private String nomeAula;
	
	 AulaEnum(String nome,int valor) {
		 nomeAula=nome;
		valorAula=valor;
	}


	public int getValorAula() {
		return valorAula;
	}


	public String getNomeAula() {
		return nomeAula;
	}


	public static List<AulaEnum> findAll(){
		ArrayList<AulaEnum> lista = new ArrayList<AulaEnum>();
		
		lista.add(AulaEnum.Aula_01);
		lista.add(AulaEnum.Aula_02);
		lista.add(AulaEnum.Aula_03);
		lista.add(AulaEnum.Aula_04);
		lista.add(AulaEnum.Aula_05);
		lista.add(AulaEnum.Aula_06);
		lista.add(AulaEnum.Aula_07);
		lista.add(AulaEnum.Aula_08);
		lista.add(AulaEnum.Aula_09);
		lista.add(AulaEnum.Aula_10);
		return lista;
	}
}
