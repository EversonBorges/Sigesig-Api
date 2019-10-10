CREATE TABLE aluno_escola_biblica(
	id_aluno_escola_biblica BIGSERIAL,
	aluno_escola_biblica integer,
	escola_biblica integer,
	dt_inicio date not null,
	ativo boolean not null,
	
	CONSTRAINT id_aluno_escola_biblica PRIMARY KEY(id_aluno_escola_biblica),
	FOREIGN KEY (aluno_escola_biblica) REFERENCES membro(id_membro),
	FOREIGN KEY (escola_biblica) REFERENCES escola_biblica (id_escola_biblica)
	);
	
	INSERT INTO aluno_escola_biblica(aluno_escola_biblica,escola_biblica,dt_inicio,ativo) 
	VALUES (1,1,'2018-05-21',true)
	