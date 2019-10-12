package com.sigesigapi.sigesig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aula")
public class Aula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAula;
	
	@NotNull
	private String descAula;
	
	public Long getIdAula() {
		return idAula;
	}
	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}
	public String getDescAula() {
		return descAula;
	}
	public void setDescAula(String descAula) {
		this.descAula = descAula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAula == null) ? 0 : idAula.hashCode());
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
		Aula other = (Aula) obj;
		if (idAula == null) {
			if (other.idAula != null)
				return false;
		} else if (!idAula.equals(other.idAula))
			return false;
		return true;
	}
}
