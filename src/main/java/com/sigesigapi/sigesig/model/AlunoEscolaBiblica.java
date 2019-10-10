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
@Table(name = "aluno_escola_biblica")
public class AlunoEscolaBiblica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlunoEscolaBiblica;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "aluno_escola_biblica")
	private Membro alunoEscolaBiblica;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "escola_biblica")
	private EscolaBiblica escolaBiblica;
	
	@NotNull
	@Column(name = "dt_inicio")
	private LocalDate dtInicio;
	
	private Boolean ativo;

	public Long getIdAlunoEscolaBiblica() {
		return idAlunoEscolaBiblica;
	}

	public void setIdAlunoEscolaBiblica(Long idAlunoEscolaBiblica) {
		this.idAlunoEscolaBiblica = idAlunoEscolaBiblica;
	}

	public Membro getAlunoEscolaBiblica() {
		return alunoEscolaBiblica;
	}

	public void setAlunoEscolaBiblica(Membro alunoEscolaBiblica) {
		this.alunoEscolaBiblica = alunoEscolaBiblica;
	}

	public EscolaBiblica getEscolaBiblica() {
		return escolaBiblica;
	}

	public void setEscolaBiblica(EscolaBiblica escolaBiblica) {
		this.escolaBiblica = escolaBiblica;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAlunoEscolaBiblica == null) ? 0 : idAlunoEscolaBiblica.hashCode());
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
		AlunoEscolaBiblica other = (AlunoEscolaBiblica) obj;
		if (idAlunoEscolaBiblica == null) {
			if (other.idAlunoEscolaBiblica != null)
				return false;
		} else if (!idAlunoEscolaBiblica.equals(other.idAlunoEscolaBiblica))
			return false;
		return true;
	}
}
