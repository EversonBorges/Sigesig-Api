CREATE TABLE aula(
	id_aula BIGSERIAL,
	desc_aula varchar(50) not null,
	
	CONSTRAINT id_aula PRIMARY KEY(id_aula)
	);
	
	INSERT INTO aula(desc_aula)
	VALUES ('Aula 01'); 
	
	INSERT INTO aula(desc_aula)
	VALUES ('Aula 02'); 
	
	INSERT INTO aula(desc_aula)
	VALUES ('Aula 03'); 
	
	INSERT INTO aula(desc_aula)
	VALUES ('Aula 04'); 