CREATE TABLE templo(
	id_templo BIGSERIAL,
	nome_fantasia varchar(30),
	razao_social varchar(30),
	cnpj varchar(20),
	dt_abertura varchar(20),
	ativo boolean,
	pastor_auxiliar_id_membro integer,
	pastor_titular_id_membro integer,
	CONSTRAINT id_templo PRIMARY KEY(id_templo)
);

INSERT INTO templo (nome_fantasia,razao_social,cnpj,dt_abertura,ativo,pastor_auxiliar_id_membro,pastor_titular_id_membro)
VALUES ('Raah Teresópolis','Igreja Batista Raah','70.473.984/0001-03','2018-12-01',true,null,null);
