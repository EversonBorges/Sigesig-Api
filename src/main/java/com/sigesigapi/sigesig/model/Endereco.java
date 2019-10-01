package com.sigesigapi.sigesig.model;

import javax.persistence.Embeddable;

import com.sigesigapi.sigesig.enums.Opcao;

@Embeddable
public class Endereco {

	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String complemento;
	private String celular;
	private String fixo;
	private String email;
	private Opcao whatsaap;
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getFixo() {
		return fixo;
	}
	public void setFixo(String fixo) {
		this.fixo = fixo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Opcao getWhatsaap() {
		return whatsaap;
	}
	public void setWhatsaap(Opcao whatsaap) {
		this.whatsaap = whatsaap;
	}
	
}
