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
@Table(name = "alunos_capacitacao_destino")
public class AlunoCapacitacaoDestino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlunoCapacitacaoDestino;
	
	@OneToOne
	@JoinColumn(name = "aluno_capacitacao_destino")
	private Membro alunoCapacitacaoDestino;
	
	@ManyToOne
	@JoinColumn(name = "modulo_capacitacao_destino")
	private ModuloCapacitacaoDestino moduloCapacitacaoDestino;
	
	@Column(name = "dt_matricula")
	private LocalDate dtMatricula;
	
	@NotNull
	private Float frequencia;

	public Long getIdAlunoCapacitacaoDestino() {
		return idAlunoCapacitacaoDestino;
	}

	public void setIdAlunoCapacitacaoDestino(Long idAlunoCapacitacaoDestino) {
		this.idAlunoCapacitacaoDestino = idAlunoCapacitacaoDestino;
	}

	public Membro getAlunoCapacitacaoDestino() {
		return alunoCapacitacaoDestino;
	}

	public void setAlunoCapacitacaoDestino(Membro alunoCapacitacaoDestino) {
		this.alunoCapacitacaoDestino = alunoCapacitacaoDestino;
	}

	public ModuloCapacitacaoDestino getModuloCapacitacaoDestino() {
		return moduloCapacitacaoDestino;
	}

	public void setModuloCapacitacaoDestino(ModuloCapacitacaoDestino moduloCapacitacaoDestino) {
		this.moduloCapacitacaoDestino = moduloCapacitacaoDestino;
	}

	public LocalDate getDtMatricula() {
		return dtMatricula;
	}

	public void setDtMatricula(LocalDate dtMatricula) {
		this.dtMatricula = dtMatricula;
	}

	public Float getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Float frequencia) {
		this.frequencia = frequencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAlunoCapacitacaoDestino == null) ? 0 : idAlunoCapacitacaoDestino.hashCode());
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
		AlunoCapacitacaoDestino other = (AlunoCapacitacaoDestino) obj;
		if (idAlunoCapacitacaoDestino == null) {
			if (other.idAlunoCapacitacaoDestino != null)
				return false;
		} else if (!idAlunoCapacitacaoDestino.equals(other.idAlunoCapacitacaoDestino))
			return false;
		return true;
	}
}
