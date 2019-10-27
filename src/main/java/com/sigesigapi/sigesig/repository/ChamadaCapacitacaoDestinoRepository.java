package com.sigesigapi.sigesig.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigesigapi.sigesig.model.ChamadaCapacitacaoDestino;

public interface ChamadaCapacitacaoDestinoRepository extends JpaRepository<ChamadaCapacitacaoDestino, Long>{

	/*
	 * select mb.nome_membro, ch.presenca,al.desc_aula from
	 * chamada_capacitacao_destino ch, membro mb,aula_modulo am, aula al where
	 * ch.aluno = mb.id_membro and ch.aula_modulo = am.id_aula_modulo and
	 * am.aula_modulo = al.id_aula and al.id_aula =3;
	 */
}
