CREATE TABLE chamada_capacitacao_destino(
	id_chamada_capacitacao_destino BIGSERIAL,
	aluno integer not null,
	aula_modulo integer not null,
	presenca boolean not null,
	
	
	CONSTRAINT id_chamada_capacitacao_destino PRIMARY KEY(id_chamada_capacitacao_destino),
	FOREIGN KEY (aluno) REFERENCES membro(id_membro),
	FOREIGN KEY (aula_modulo) REFERENCES aula_modulo(id_aula_modulo)
	);
	
	INSERT INTO chamada_capacitacao_destino(aluno,aula_modulo,presenca) 
	VALUES (1,1,true);
	
	INSERT INTO chamada_capacitacao_destino(aluno,aula_modulo,presenca) 
	VALUES (2,2,true);
	
	INSERT INTO chamada_capacitacao_destino(aluno,aula_modulo,presenca) 
	VALUES (3,1,true);