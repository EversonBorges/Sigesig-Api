package com.sigesigapi.sigesig.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sigesigapi.sigesig.enums.Religiao;

@Entity
@Table(name = "participante_celula")
public class ParticipanteCelula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParticipante;
	
	@NotNull
	private String nomeParticipante;
	
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;
	
	@Enumerated(EnumType.STRING)
	private Religiao religiaoParticipante;
	
	//@ManyToOne
	//@Column(name = "celula")
	//private Celula celula;

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Religiao getReligiaoParticipante() {
		return religiaoParticipante;
	}

	public void setReligiaoParticipante(Religiao religiaoParticipante) {
		this.religiaoParticipante = religiaoParticipante;
	}

	/*
	 * public Celula getCelula() { return celula; }
	 * 
	 * public void setCelula(Celula celula) { this.celula = celula; }
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idParticipante == null) ? 0 : idParticipante.hashCode());
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
		ParticipanteCelula other = (ParticipanteCelula) obj;
		if (idParticipante == null) {
			if (other.idParticipante != null)
				return false;
		} else if (!idParticipante.equals(other.idParticipante))
			return false;
		return true;
	}
}
