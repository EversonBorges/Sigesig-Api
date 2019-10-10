CREATE TABLE participante_celula(
	id_participante BIGSERIAL,
	nome_participante varchar(100) not null,
	dt_nascimento date not null,
	celula integer not null,
	religiao_participante varchar(20) not null,

	CONSTRAINT id_participante PRIMARY KEY(id_participante),
	FOREIGN KEY (celula) REFERENCES celula(id_celula)
	);
	
	INSERT INTO participante_celula(nome_participante,dt_nascimento,celula,religiao_participante) 
	VALUES ('gabriel Collen','1994-05-21',1,'Católico')
	