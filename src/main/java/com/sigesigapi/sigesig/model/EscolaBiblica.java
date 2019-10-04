package com.sigesigapi.sigesig.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sigesigapi.sigesig.enums.Status;
import com.sigesigapi.sigesig.enums.Turmas;

@Entity
@Table(name = "escola_biblica")
public class EscolaBiblica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEscolaBiblica;
	
	@Enumerated(EnumType.STRING)
	private Turmas turma;
	

	private Membro professor;
	private Calendar dtInicio;
	private Status tipo;
	private Calendar dtNasc;
	private Templo templo;
	
	
}
