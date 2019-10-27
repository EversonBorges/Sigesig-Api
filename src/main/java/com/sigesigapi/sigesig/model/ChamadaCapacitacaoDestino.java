package com.sigesigapi.sigesig.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chamada_capacitacao_destino")
public class ChamadaCapacitacaoDestino {

	//Teste
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChamadaCapacitacaoDestino;
	
	@ManyToMany(cascade = {CascadeType.DETACH})
	@JoinTable(name="chamada_aluno", joinColumns=
		{@JoinColumn(name="id_chamada")}, inverseJoinColumns=
			{@JoinColumn(name="id_membro")})
	private List<Membro> alunos;
	
	@OneToOne
	@JoinColumn(name = "aula_modulo")
	private AulaModulo aulaModulo;
	
	@NotNull
	private Boolean presenca;

	public Long getIdChamadaCapacitacaoDestino() {
		return idChamadaCapacitacaoDestino;
	}

	public void setIdChamadaCapacitacaoDestino(Long idChamadaCapacitacaoDestino) {
		this.idChamadaCapacitacaoDestino = idChamadaCapacitacaoDestino;
	}

	public List<Membro> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Membro> alunos) {
		this.alunos = alunos;
	}

	public AulaModulo getAulaModulo() {
		return aulaModulo;
	}

	public void setAulaModulo(AulaModulo aulaModulo) {
		this.aulaModulo = aulaModulo;
	}

	public Boolean getPresenca() {
		return presenca;
	}

	public void setPresenca(Boolean presenca) {
		this.presenca = presenca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idChamadaCapacitacaoDestino == null) ? 0 : idChamadaCapacitacaoDestino.hashCode());
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
		ChamadaCapacitacaoDestino other = (ChamadaCapacitacaoDestino) obj;
		if (idChamadaCapacitacaoDestino == null) {
			if (other.idChamadaCapacitacaoDestino != null)
				return false;
		} else if (!idChamadaCapacitacaoDestino.equals(other.idChamadaCapacitacaoDestino))
			return false;
		return true;
	}
}
