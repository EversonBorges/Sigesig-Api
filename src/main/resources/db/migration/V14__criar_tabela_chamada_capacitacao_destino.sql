CREATE TABLE chamada_capacitacao_destino(
	id_chamada_capacitacao_destino BIGSERIAL,
	aluno_capacitacao_destino integer not null,
	aula_modulo integer not null,
	presenca boolean not null,
	
	
	CONSTRAINT id_chamada_capacitacao_destino PRIMARY KEY(id_chamada_capacitacao_destino),
	FOREIGN KEY (aluno_capacitacao_destino) REFERENCES aluno_capacitacao_destino(id_aluno_capacitacao_destino),
	FOREIGN KEY (aula_modulo) REFERENCES aula_modulo(id_aula_modulo)
	);
	
	INSERT INTO chamada_capacitacao_destino(aluno_capacitacao_destino,aula_modulo,presenca) 
	VALUES (1,1,true)