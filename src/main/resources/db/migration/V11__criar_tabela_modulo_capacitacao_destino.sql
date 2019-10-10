CREATE TABLE modulo_capacitacao_destino(
	id_modulo_capacitacao_destino BIGSERIAL,
	turma_capacitacao_destino integer not null,
	dt_inicio date not null,
	dt_termino date not null,
	modulo integer not null,
	
	CONSTRAINT id_modulo_capacitacao_destino PRIMARY KEY(id_modulo_capacitacao_destino),
	FOREIGN KEY (turma_capacitacao_destino) REFERENCES turma_capacitacao_destino(id_turma_capacitacao_destino),
	FOREIGN KEY (modulo) REFERENCES modulo(id_modulo)
	);
	
	INSERT INTO modulo_capacitacao_destino(turma_capacitacao_destino,dt_inicio,dt_termino,modulo) 
	VALUES (1,'2018-05-21','2018-12-21',1)