package com.sigesigapi.sigesig.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aula_modulo")
public class AulaModulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAulaModulo;
	
	@ManyToOne
	@JoinColumn(name =  "modulo")
	private Modulo modulo;
	
	@ManyToOne
	@JoinColumn(name = "aula_modulo")
	private Aula aulaModulo;
	
	@OneToOne
	@JoinColumn(name = "professor_aula")
	private Membro professorAula;
	
	@Column(name = "dt_aula")
	private LocalDate dtAula;

	public Long getIdAulaModulo() {
		return idAulaModulo;
	}

	public void setIdAulaModulo(Long idAulaModulo) {
		this.idAulaModulo = idAulaModulo;
	}

	public LocalDate getDtAula() {
		return dtAula;
	}

	public void setDtAula(LocalDate dtAula) {
		this.dtAula = dtAula;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Aula getAulaModulo() {
		return aulaModulo;
	}

	public void setAulaModulo(Aula aulaModulo) {
		this.aulaModulo = aulaModulo;
	}

	public Membro getProfessorAula() {
		return professorAula;
	}

	public void setProfessorAula(Membro professorAula) {
		this.professorAula = professorAula;
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
