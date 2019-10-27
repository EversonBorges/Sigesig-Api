CREATE TABLE celula(
	id_celula BIGSERIAL,
	nome_celula varchar(100) not null,
	dt_abertura date not null,
	lider_celula integer not null,
	timoteo_celula integer not null,
	templo integer not null,
	anfitriao varchar(100) not null,
	supervisor_celula integer not null,
	supervisor_celula_area integer not null,
	qtd_participante integer,
	ativo boolean not null,
	
	CONSTRAINT id_celula PRIMARY KEY(id_celula),
	FOREIGN KEY (lider_celula) REFERENCES membro(id_membro),
	FOREIGN KEY (timoteo_celula) REFERENCES membro(id_membro),
	FOREIGN KEY (supervisor_celula) REFERENCES membro(id_membro),
	FOREIGN KEY (supervisor_celula_area) REFERENCES membro(id_membro),
	FOREIGN KEY (templo) REFERENCES templo (id_templo)
	);
	
	INSERT INTO celula(nome_celula,dt_abertura,lider_celula,timoteo_celula,templo,anfitriao,
						supervisor_celula,supervisor_celula_area,qtd_participante,ativo) 
	VALUES ('Manaem','2018-05-21',1,1,1,'Jose Moreira',1,1,22,true);
	
	INSERT INTO celula(nome_celula,dt_abertura,lider_celula,timoteo_celula,templo,anfitriao,
						supervisor_celula,supervisor_celula_area,qtd_participante,ativo) 
	VALUES ('Leao Juda','2018-05-21',1,1,1,'Claudio Alves ',1,1,22,true);
	
	INSERT INTO celula(nome_celula,dt_abertura,lider_celula,timoteo_celula,templo,anfitriao,
						supervisor_celula,supervisor_celula_area,qtd_participante,ativo) 
	VALUES ('Vencedores','2018-05-21',1,1,1,'Maria Moreira',1,1,22,true);
	