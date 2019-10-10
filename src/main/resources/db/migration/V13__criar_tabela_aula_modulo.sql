CREATE TABLE aula_modulo(
	id_aula_modulo BIGSERIAL,
	desc_aula varchar(50),
	dt_aula date not null,
	professor_aula integer not null,
	modulo_aula integer not null,
	
	CONSTRAINT id_aula_modulo PRIMARY KEY(id_aula_modulo),
	FOREIGN KEY (professor_aula) REFERENCES membro(id_membro),
	FOREIGN KEY (modulo_aula) REFERENCES modulo_capacitacao_destino(id_modulo_capacitacao_destino)
	);
	
	INSERT INTO aula_modulo(desc_aula,dt_aula,professor_aula,modulo_aula) 
	VALUES ('Aula_01','2019-05-12',1,1)