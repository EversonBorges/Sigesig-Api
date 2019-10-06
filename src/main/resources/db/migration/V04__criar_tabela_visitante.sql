CREATE TABLE visitante(
	id_visitante BIGSERIAL,
	nome_visitante varchar(50) not null,
	dt_nasc date not null,
	sexo varchar(15),
	templo integer,
	religiao varchar(20) not null,
	respo_convidar integer,
	visitado varchar(5) not null,
	parente varchar(5) not null,
	parentesco varchar(10),
	parente_de_quem integer,
	
	CONSTRAINT id_visitante PRIMARY KEY(id_visitante),
	FOREIGN KEY (respo_convidar) REFERENCES membro(id_membro),
	FOREIGN KEY (parente_de_quem) REFERENCES membro(id_membro),
	FOREIGN KEY (templo) REFERENCES templo (id_templo)
	);
	
	INSERT INTO visitante(nome_visitante,dt_nasc,sexo,templo,religiao,respo_convidar,visitado,parente,parentesco,parente_de_quem) 
	VALUES ('Marcio Vargas','1987-12-25','Masculino',1,'Católico',1,'Não','Sim','Irmão',1)
	