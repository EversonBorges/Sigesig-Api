package com.sigesigapi.sigesig.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sigesigapi.sigesig.enums.AulaEnum;

@Entity
@Table(name = "aula_modulo")
public class AulaModulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAulaModulo;
	
	@Enumerated(EnumType.STRING)
	private AulaEnum descAula;
	
	@Column(name = "dt_aula")
	private LocalDate dtAula;
	
	@OneToOne
	@JoinColumn(name = "professor_aula")
	private Membro professorAula;
	
	@ManyToOne
	@JoinColumn(name = "modulo_aula")
	private ModuloCapacitacaoDestino moduloAula;

	public Long getIdAulaModulo() {
		return idAulaModulo;
	}

	public void setIdAulaModulo(Long idAulaModulo) {
		this.idAulaModulo = idAulaModulo;
	}

	public AulaEnum getDescAula() {
		return descAula;
	}

	public void setDescAula(AulaEnum descAula) {
		this.descAula = descAula;
	}

	public LocalDate getDtAula() {
		return dtAula;
	}

	public void setDtAula(LocalDate dtAula) {
		this.dtAula = dtAula;
	}

	public Membro getProfessorAula() {
		return professorAula;
	}

	public void setProfessorAula(Membro professorAula) {
		this.professorAula = professorAula;
	}

	public ModuloCapacitacaoDestino getModuloAula() {
		return moduloAula;
	}

	public void setModuloAula(ModuloCapacitacaoDestino moduloAula) {
		this.moduloAula = moduloAula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAulaModulo == null) ? 0 : idAulaModulo.hashCode());
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
		AulaModulo other = (AulaModulo) obj;
		if (idAulaModulo == null) {
			if (other.idAulaModulo != null)
				return false;
		} else if (!idAulaModulo.equals(other.idAulaModulo))
			return false;
		return true;
	}
}
