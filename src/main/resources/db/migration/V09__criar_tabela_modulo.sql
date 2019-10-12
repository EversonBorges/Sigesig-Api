CREATE TABLE modulo(
	id_modulo BIGSERIAL,
	desc_modulo varchar(50),
	CONSTRAINT id_modulo PRIMARY KEY(id_modulo)
	);
	
	INSERT INTO modulo(desc_modulo) 
	VALUES ('Modulo 1')
	