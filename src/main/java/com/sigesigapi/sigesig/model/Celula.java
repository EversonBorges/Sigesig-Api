package com.sigesigapi.sigesig.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "celula")
public class Celula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCelula;
	
	@NotNull
	private String nomeCelula;
	
	@Column(name = "dt_abertura")
	private LocalDate dtAbertura;
	
	@OneToOne
	@JoinColumn(name = "lider_celula")
	private Membro liderCelula;
	
	@OneToOne
	@JoinColumn(name = "timoteo_celula")
	private Membro timoteoCelula;
	
	@NotNull
	private String anfitriao;
	
	@OneToOne
	@JoinColumn(name = "supervisor_celula")
	private Membro supervisorCelula;
	
	@OneToOne
	@JoinColumn(name = "supervisor_celula_area")
	private Membro supervisorCelulaArea;
	
	@ManyToOne
	@JoinColumn(name = "templo")
	private Templo templo;
	
	@NotNull
	@Column(name = "qtd_participante")
	private Integer qtdParticipantes;
	
	@NotNull
	private Boolean ativo;

	public Long getIdCelula() {
		return idCelula;
	}

	public void setIdCelula(Long idCelula) {
		this.idCelula = idCelula;
	}

	public String getNomeCelula() {
		return nomeCelula;
	}

	public void setNomeCelula(String nomeCelula) {
		this.nomeCelula = nomeCelula;
	}

	public LocalDate getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(LocalDate dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Membro getLiderCelula() {
		return liderCelula;
	}

	public void setLiderCelula(Membro liderCelula) {
		this.liderCelula = liderCelula;
	}

	public Membro getTimoteoCelula() {
		return timoteoCelula;
	}

	public void setTimoteoCelula(Membro timoteoCelula) {
		this.timoteoCelula = timoteoCelula;
	}

	public String getAnfitriao() {
		return anfitriao;
	}

	public void setAnfitriao(String anfitriao) {
		this.anfitriao = anfitriao;
	}

	public Membro getSupervisorCelula() {
		return supervisorCelula;
	}

	public void setSupervisorCelula(Membro supervisorCelula) {
		this.supervisorCelula = supervisorCelula;
	}

	public Membro getSupervisorCelulaArea() {
		return supervisorCelulaArea;
	}

	public void setSupervisorCelulaArea(Membro supervisorCelulaArea) {
		this.supervisorCelulaArea = supervisorCelulaArea;
	}

	public Templo getTemplo() {
		return templo;
	}

	public void setTemplo(Templo templo) {
		this.templo = templo;
	}

	public Integer getQtdParticipantes() {
		return qtdParticipantes;
	}

	public void setQtdParticipantes(Integer qtdParticipantes) {
		this.qtdParticipantes = qtdParticipantes;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCelula == null) ? 0 : idCelula.hashCode());
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
		Celula other = (Celula) obj;
		if (idCelula == null) {
			if (other.idCelula != null)
				return false;
		} else if (!idCelula.equals(other.idCelula))
			return false;
		return true;
	}
}
