package com.sigesigapi.sigesig.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ministerio")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ministerio implements Serializable {
	
	private static final long serialVersionUID = 2071179739235330639L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMinisterio;
	
	@NotNull
	@Size(min = 3, max = 20)
	private String descMinisterio;
	
	public Long getIdMinisterio() {
		return idMinisterio;
	}
	public void setIdMinisterio(Long idMinisterio) {
		this.idMinisterio = idMinisterio;
	}
	public String getDescMinisterio() {
		return descMinisterio;
	}
	public void setDescMinisterio(String descMinisterio) {
		this.descMinisterio = descMinisterio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMinisterio == null) ? 0 : idMinisterio.hashCode());
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
		Ministerio other = (Ministerio) obj;
		if (idMinisterio == null) {
			if (other.idMinisterio != null)
				return false;
		} else if (!idMinisterio.equals(other.idMinisterio))
			return false;
		return true;
	}
	
}
