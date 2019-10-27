CREATE TABLE aula_modulo(
	id_aula_modulo BIGSERIAL,
	modulo integer not null,
	dt_aula date not null,
	professor_aula integer not null,
	aula_modulo integer not null,
	
	CONSTRAINT id_aula_modulo PRIMARY KEY(id_aula_modulo),
	FOREIGN KEY (professor_aula) REFERENCES membro(id_membro),
	FOREIGN KEY (aula_modulo) REFERENCES aula(id_aula),
	FOREIGN KEY (modulo) REFERENCES modulo(id_modulo)
	);
	
	INSERT INTO aula_modulo(modulo,dt_aula,professor_aula,aula_modulo) 
	VALUES (1,'2019-05-12',1,1);
	
	INSERT INTO aula_modulo(modulo,dt_aula,professor_aula,aula_modulo) 
	VALUES (2,'2019-05-12',1,3);
	
	INSERT INTO aula_modulo(modulo,dt_aula,professor_aula,aula_modulo) 
	VALUES (1,'2019-05-12',1,1);
	
	INSERT INTO aula_modulo(modulo,dt_aula,professor_aula,aula_modulo) 
	VALUES (2,'2019-05-12',1,2);