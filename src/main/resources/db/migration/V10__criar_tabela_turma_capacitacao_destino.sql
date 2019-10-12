CREATE TABLE turma_capacitacao_destino(
	id_turma_capacitacao_destino BIGSERIAL,
	templo integer not null,
	dt_inicio date not null,
	dt_termino date not null,
	ativo boolean not null,
	desc_turma_capacitacao_destino varchar(50),
	
	CONSTRAINT id_turma_capacitacao_destino PRIMARY KEY(id_turma_capacitacao_destino),
	FOREIGN KEY (templo) REFERENCES templo(id_templo)
	);
	
	INSERT INTO turma_capacitacao_destino(templo,dt_inicio,dt_termino,ativo,desc_turma_capacitacao_destino) 
	VALUES (1,'2018-05-21','2018-12-21',true,'2019/1')
	