package com.sigesigapi.sigesig.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sigesigapi.sigesig.enums.Opcao;
import com.sigesigapi.sigesig.enums.Religiao;
import com.sigesigapi.sigesig.enums.Sexo;

@Entity
@Table(name="visitante")
public class Visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVisitante;
	
	@NotNull
	private String nomeVisitante;
	
	private Calendar dtNasc;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@ManyToOne
	private Templo templo;
	
	@Enumerated(EnumType.STRING)
	private Religiao religiao;
	
	@ManyToOne
	private Membro respoConvidar;
	
	@Enumerated(EnumType.STRING)
	private Opcao visitado;
	
	@Enumerated(EnumType.STRING)
	private Opcao parente;
	
	private String parentesco;
	
	@ManyToOne
	private Membro parenteDeQuem;

	public Long getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(Long idVisitante) {
		this.idVisitante = idVisitante;
	}

	public String getNomeVisitante() {
		return nomeVisitante;
	}

	public void setNomeVisitante(String nomeVisitante) {
		this.nomeVisitante = nomeVisitante;
	}

	public Calendar getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Calendar dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Templo getTemplo() {
		return templo;
	}

	public void setTemplo(Templo templo) {
		this.templo = templo;
	}

	public Religiao getReligiao() {
		return religiao;
	}

	public void setReligiao(Religiao religiao) {
		this.religiao = religiao;
	}

	public Membro getRespoConvidar() {
		return respoConvidar;
	}

	public void setRespoConvidar(Membro respoConvidar) {
		this.respoConvidar = respoConvidar;
	}

	public Opcao getVisitado() {
		return visitado;
	}

	public void setVisitado(Opcao visitado) {
		this.visitado = visitado;
	}

	public Opcao getParente() {
		return parente;
	}

	public void setParente(Opcao parente) {
		this.parente = parente;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Membro getParenteDeQuem() {
		return parenteDeQuem;
	}

	public void setParenteDeQuem(Membro parenteDeQuem) {
		this.parenteDeQuem = parenteDeQuem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVisitante == null) ? 0 : idVisitante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitante other = (Visitante) obj;
		if (idVisitante == null) {
			if (other.idVisitante != null)
				return false;
		} else if (!idVisitante.equals(other.idVisitante))
			return false;
		return true;
	}
}
