CREATE TABLE visitante(
	id_visitante BIGSERIAL,
	nome_visitante varchar(50) not null,
	dt_nasc date not null,
	sexo varchar(15),
	templo_id_templo integer,
	religiao varchar(20) not null,
	respo_convidar_id_membro integer,
	visitado varchar(5) not null,
	parente varchar(5) not null,
	parentesco varchar(10),
	parente_de_quem_id_membro integer,
	
	CONSTRAINT id_visitante PRIMARY KEY(id_visitante),
	FOREIGN KEY (respo_convidar_id_membro) REFERENCES membro(id_membro),
	FOREIGN KEY (parente_de_quem_id_membro) REFERENCES membro(id_membro),
	FOREIGN KEY (templo_id_templo) REFERENCES templo (id_templo)
	);
	
	INSERT INTO visitante(nome_visitante,dt_nasc,sexo,templo_id_templo,religiao,respo_convidar_id_membro,visitado,parente,parentesco,parente_de_quem_id_membro) 
	VALUES ('Marcio Vargas','1987-12-25','Masculino',1,'Catolico',1,'Não','Sim','Irmão',1)
	