CREATE TABLE turma_modulo(
	id_turma integer not null,
	id_modulo integer not null,
	
	FOREIGN KEY (id_turma) REFERENCES turma_capacitacao_destino(id_turma_capacitacao_destino),
	FOREIGN KEY (id_modulo) REFERENCES modulo(id_modulo)
	);
	
	INSERT INTO turma_modulo(id_turma,id_modulo)
	VALUES (1,1);
	
	INSERT INTO turma_modulo(id_turma,id_modulo)
	VALUES (2,2);
	
	INSERT INTO turma_modulo(id_turma,id_modulo)
	VALUES (3,1); 