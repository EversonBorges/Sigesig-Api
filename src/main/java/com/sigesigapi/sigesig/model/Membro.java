package com.sigesigapi.sigesig.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sigesigapi.sigesig.enums.Opcao;
import com.sigesigapi.sigesig.enums.Sexo;
import com.sigesigapi.sigesig.enums.Turmas;

@Entity
@Table(name = "membro")
public class Membro implements Serializable{

	private static final long serialVersionUID = -8673684793733268061L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembro;
	
	@NotNull
	private String nomeMembro;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String rg;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Opcao batizado;
	
	@NotNull
	@Column(name ="dt_nasc")
	private LocalDate dtNasc;
	
	@ManyToOne
	@JoinColumn(name = "ministerio")
	private Ministerio ministerio;
	
	@NotNull
	private Boolean ativo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@ManyToOne
	@JoinColumn(name = "templo")
	private Templo templo;
	
	@NotNull
	private int idade;
	
	@Enumerated(EnumType.STRING)
	private Turmas turma;
	
	private Boolean matriculaEscolaBiblica;
	
	private Boolean capacitacaoConcluido;
	
	private Boolean matriculaLider;
	
	@Embedded
	private Endereco endereco;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "alunos") private ChamadaCapacitacaoDestino chamada;
	 */
	public Long getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Long idMembro) {
		this.idMembro = idMembro;
	}

	public String getNomeMembro() {
		return nomeMembro;
	}

	public void setNomeMembro(String nomeMembro) {
		this.nomeMembro = nomeMembro;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Opcao getBatizado() {
		return batizado;
	}

	public void setBatizado(Opcao batizado) {
		this.batizado = batizado;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Ministerio getMinisterio() {
		return ministerio;
	}

	public void setMinisterio(Ministerio ministerio) {
		this.ministerio = ministerio;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Templo getTemplo() {
		return templo;
	}

	public void setTemplo(Templo templo) {
		this.templo = templo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Turmas getTurma() {
		return turma;
	}

	public void setTurma(Turmas turma) {
		this.turma = turma;
	}

	public Boolean getMatriculaEscolaBiblica() {
		return matriculaEscolaBiblica;
	}

	public void setMatriculaEscolaBiblica(Boolean matriculaEscolaBiblica) {
		this.matriculaEscolaBiblica = matriculaEscolaBiblica;
	}

	public Boolean getCapacitacaoConcluido() {
		return capacitacaoConcluido;
	}

	public void setCapacitacaoConcluido(Boolean capacitacaoConcluido) {
		this.capacitacaoConcluido = capacitacaoConcluido;
	}

	public Boolean getMatriculaLider() {
		return matriculaLider;
	}

	public void setMatriculaLider(Boolean matriculaLider) {
		this.matriculaLider = matriculaLider;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/*
	 * public ChamadaCapacitacaoDestino getChamada() { return chamada; }
	 * 
	 * public void setChamada(ChamadaCapacitacaoDestino chamada) { this.chamada =
	 * chamada; }
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMembro == null) ? 0 : idMembro.hashCode());
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
		Membro other = (Membro) obj;
		if (idMembro == null) {
			if (other.idMembro != null)
				return false;
		} else if (!idMembro.equals(other.idMembro))
			return false;
		return true;
	}
	
}
