package com.sigesigapi.sigesig.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "templo")
public class Templo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTemplo;
	
	@NotNull
	private String nomeFantasia;
	
	@NotNull
	private String razaoSocial;
	
	@NotNull
	private String cnpj;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar dtAbertura;
	
//	
//	@ManyToOne
//	private Membro pastorAuxiliar;
//	
//	@ManyToOne
//	private Membro pastorTitular;
	
	@NotNull
	private Boolean ativo;
	
	public Long getIdTemplo() {
		return idTemplo;
	}
	public void setIdTemplo(Long idTemplo) {
		this.idTemplo = idTemplo;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Calendar getDtAbertura() {
		return dtAbertura;
	}
	public void setDtAbertura(Calendar dtAbertura) {
		this.dtAbertura = dtAbertura;
	}
//	public Membro getPastorAuxiliar() {
//		return pastorAuxiliar;
//	}
//	public void setPastorAuxiliar(Membro pastorAuxiliar) {
//		this.pastorAuxiliar = pastorAuxiliar;
//	}
//	public Membro getPastorTitular() {
//		return pastorTitular;
//	}
//	public void setPastorTitular(Membro pastorTitular) {
//		this.pastorTitular = pastorTitular;
//	}
	public Boolean getTipo() {
		return ativo;
	}
	public void setTipo(Boolean tipo) {
		this.ativo = tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTemplo == null) ? 0 : idTemplo.hashCode());
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
		Templo other = (Templo) obj;
		if (idTemplo == null) {
			if (other.idTemplo != null)
				return false;
		} else if (!idTemplo.equals(other.idTemplo))
			return false;
		return true;
	}
}
