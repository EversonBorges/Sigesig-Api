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
@Table(name = "modulo_capacitacao_destino")
public class ModuloCapacitacaoDestino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModulo;
	
	@Column(name = "dt_inicio")
	private LocalDate dtInicio;
	
	@Column(name = "dt_termino")
	private LocalDate dtTermino;
	
	@ManyToOne
	@JoinColumn(name = "turma_capacitacao_destino")
	private TurmaCapacitacaoDestino turmaCapacitacaoDestino;
	
	@OneToOne
	@JoinColumn(name = "modulo")
	private Modulo modulo;
	
	@NotNull
	private String descModuloCapacitacaoDestino;

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
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

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getDescModuloCapacitacaoDestino() {
		return descModuloCapacitacaoDestino;
	}

	public void setDescModuloCapacitacaoDestino(String descModuloCapacitacaoDestino) {
		this.descModuloCapacitacaoDestino = descModuloCapacitacaoDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idModulo == null) ? 0 : idModulo.hashCode());
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
		if (idModulo == null) {
			if (other.idModulo != null)
				return false;
		} else if (!idModulo.equals(other.idModulo))
			return false;
		return true;
	}
}
