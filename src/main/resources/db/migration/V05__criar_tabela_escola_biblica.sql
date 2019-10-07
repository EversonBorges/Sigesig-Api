CREATE TABLE escola_biblica(
	id_escola_biblica BIGSERIAL,
	turma varchar(50) not null,
	professor integer not null,
	dt_inicio date not null,
	templo integer not null,
	ativo boolean not null,
	
	CONSTRAINT id_escola_biblica PRIMARY KEY(id_escola_biblica),
	FOREIGN KEY (professor) REFERENCES membro(id_membro),
	FOREIGN KEY (templo) REFERENCES templo (id_templo)
	);
	
	INSERT INTO escola_biblica(turma,professor,dt_inicio,templo,ativo) 
	VALUES ('Adultos',1,'2018-05-21',1,true)
	