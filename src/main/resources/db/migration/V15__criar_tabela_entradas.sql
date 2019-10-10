CREATE TABLE entrada(
	id_entrada BIGSERIAL,
	operacao varchar(50) not null,
	valor_entrada numeric not null,
	dt_entrada date not null,
	dizimista integer,
	
	
	CONSTRAINT id_entrada PRIMARY KEY(id_entrada),
	FOREIGN KEY (dizimista) REFERENCES membro(id_membro)
	);
	
	INSERT INTO entrada(operacao,valor_entrada,dt_entrada,dizimista)
	VALUES ('OFERTA',150.60,'2019-10-10',1) 