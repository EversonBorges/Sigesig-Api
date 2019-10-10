CREATE TABLE aluno_capacitacao_destino(
	id_aluno_capacitacao_destino BIGSERIAL,
	aluno_capacitacao_destino integer not null,
	modulo_capacitacao_destino integer not null,
	dt_matricula date not null,
	frequencia real not null,
	
	CONSTRAINT id_aluno_capacitacao_destino PRIMARY KEY(id_aluno_capacitacao_destino),
	FOREIGN KEY (aluno_capacitacao_destino) REFERENCES membro(id_membro),
	FOREIGN KEY (modulo_capacitacao_destino) REFERENCES modulo_capacitacao_destino(id_modulo_capacitacao_destino)
	);
	
	INSERT INTO aluno_capacitacao_destino(aluno_capacitacao_destino,modulo_capacitacao_destino,dt_matricula,frequencia) 
	VALUES (1,1,'2018-12-21',1.5)