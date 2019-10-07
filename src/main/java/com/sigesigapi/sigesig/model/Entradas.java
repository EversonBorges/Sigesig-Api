package com.sigesigapi.sigesig.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sigesigapi.sigesig.enums.OperacaoEntrada;

@Entity
@Table(name = "entrada")
public class Entradas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEntrada;
	
	@Enumerated(EnumType.STRING)
	private OperacaoEntrada operacao;
	
	@NotNull
	private BigDecimal valorEntrada;
	
	@Column(name = "dt_entrada")
	private LocalDate dtEntrada;
	
	@OneToOne
	@JoinColumn(name = "dizimista")
	private Membro dizimista;

	public Long getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(Long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public OperacaoEntrada getOperacao() {
		return operacao;
	}

	public void setOperacao(OperacaoEntrada operacao) {
		this.operacao = operacao;
	}

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public LocalDate getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(LocalDate dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Membro getDizimista() {
		return dizimista;
	}

	public void setDizimista(Membro dizimista) {
		this.dizimista = dizimista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEntrada == null) ? 0 : idEntrada.hashCode());
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
		Entradas other = (Entradas) obj;
		if (idEntrada == null) {
			if (other.idEntrada != null)
				return false;
		} else if (!idEntrada.equals(other.idEntrada))
			return false;
		return true;
	}
}
