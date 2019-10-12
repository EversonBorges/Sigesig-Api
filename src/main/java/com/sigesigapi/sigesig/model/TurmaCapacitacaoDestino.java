package com.sigesigapi.sigesig.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "turma_capacitacao_destino")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurmaCapacitacaoDestino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTurmaCapacitacaoDestino;
	
	@ManyToOne
	@JoinColumn(name = "templo")
	private Templo templo;
	
	@Column(name = "dt_inicio")
	private LocalDate dtInicio;
	
	@Column(name = "dt_termino")
	private LocalDate dtTermino;
	
	@NotNull
	private Boolean ativo;
	
	@ManyToMany(cascade = {CascadeType.DETACH})
	@JoinTable(name="turma_modulo", joinColumns=
		{@JoinColumn(name="id_turma")}, inverseJoinColumns=
			{@JoinColumn(name="id_modulo")})
	private List<Modulo> modulo;
	
	@NotNull
	private String descTurmaCapacitacaoDestino;

	public Long getIdTurmaCapacitacaoDestino() {
		return idTurmaCapacitacaoDestino;
	}

	public void setIdTurmaCapacitacaoDestino(Long idTurmaCapacitacaoDestino) {
		this.idTurmaCapacitacaoDestino = idTurmaCapacitacaoDestino;
	}

	public Templo getTemplo() {
		return templo;
	}

	public void setTemplo(Templo templo) {
		this.templo = templo;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescTurmaCapacitacaoDestino() {
		return descTurmaCapacitacaoDestino;
	}

	public void setDescTurmaCapacitacaoDestino(String descTurmaCapacitacaoDestino) {
		this.descTurmaCapacitacaoDestino = descTurmaCapacitacaoDestino;
	}

	public List<Modulo> getModulo() {
		return modulo;
	}

	public void setModulo(List<Modulo> modulo) {
		this.modulo = modulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurmaCapacitacaoDestino == null) ? 0 : idTurmaCapacitacaoDestino.hashCode());
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
		TurmaCapacitacaoDestino other = (TurmaCapacitacaoDestino) obj;
		if (idTurmaCapacitacaoDestino == null) {
			if (other.idTurmaCapacitacaoDestino != null)
				return false;
		} else if (!idTurmaCapacitacaoDestino.equals(other.idTurmaCapacitacaoDestino))
			return false;
		return true;
	}
}
