package com.sigesigapi.sigesig.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modulo_capacitacao_destino")
public class ModuloCapacitacaoDestino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModuloCapacitacaoDestino;
	
	@Column(name = "dt_inicio")
	private LocalDate dtInicio;
	
	@Column(name = "dt_termino")
	private LocalDate dtTermino;
	
	@ManyToOne
	@JoinColumn(name = "turma_capacitacao_destino")
	private TurmaCapacitacaoDestino turmaCapacitacaoDestino;
	
	public Long getIdModuloCapacitacaoDestino() {
		return idModuloCapacitacaoDestino;
	}

	public void setIdModuloCapacitacaoDestino(Long idModuloCapacitacaoDestino) {
		this.idModuloCapacitacaoDestino = idModuloCapacitacaoDestino;
	}

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDate getDtTermino() {
		return dtTermino;
	}

	public void setDtTermino(LocalDate dtTermino) {
		this.dtTermino = dtTermino;
	}

	public TurmaCapacitacaoDestino getTurmaCapacitacaoDestino() {
		return turmaCapacitacaoDestino;
	}

	public void setTurmaCapacitacaoDestino(TurmaCapacitacaoDestino turmaCapacitacaoDestino) {
		this.turmaCapacitacaoDestino = turmaCapacitacaoDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idModuloCapacitacaoDestino == null) ? 0 : idModuloCapacitacaoDestino.hashCode());
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
		ModuloCapacitacaoDestino other = (ModuloCapacitacaoDestino) obj;
		if (idModuloCapacitacaoDestino == null) {
			if (other.idModuloCapacitacaoDestino != null)
				return false;
		} else if (!idModuloCapacitacaoDestino.equals(other.idModuloCapacitacaoDestino))
			return false;
		return true;
	}
}
