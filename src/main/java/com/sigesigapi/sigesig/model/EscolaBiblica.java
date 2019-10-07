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
import javax.validation.constraints.NotNull;

import com.sigesigapi.sigesig.enums.Turmas;

@Entity
@Table(name = "escola_biblica")
public class EscolaBiblica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEscolaBiblica;
	
	@Enumerated(EnumType.STRING)
	private Turmas turma;
	
	@OneToOne
	@JoinColumn(name = "professor")
	private Membro professor;
	
	@NotNull
	@Column(name ="dt_inicio")
	private LocalDate dtInicio;
	
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "templo")
	private Templo templo;

	public Long getIdEscolaBiblica() {
		return idEscolaBiblica;
	}

	public void setIdEscolaBiblica(Long idEscolaBiblica) {
		this.idEscolaBiblica = idEscolaBiblica;
	}

	public Turmas getTurma() {
		return turma;
	}

	public void setTurma(Turmas turma) {
		this.turma = turma;
	}

	public Membro getProfessor() {
		return professor;
	}

	public void setProfessor(Membro professor) {
		this.professor = professor;
	}

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Templo getTemplo() {
		return templo;
	}

	public void setTemplo(Templo templo) {
		this.templo = templo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEscolaBiblica == null) ? 0 : idEscolaBiblica.hashCode());
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
		EscolaBiblica other = (EscolaBiblica) obj;
		if (idEscolaBiblica == null) {
			if (other.idEscolaBiblica != null)
				return false;
		} else if (!idEscolaBiblica.equals(other.idEscolaBiblica))
			return false;
		return true;
	}
}
