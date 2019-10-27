CREATE TABLE membro(
	id_membro BIGSERIAL,
	nome_membro varchar(50) not null,
	cpf varchar(20) not null,
	rg varchar(20) not null,
	batizado varchar(5) not null,
	dt_nasc date not null,
	ministerio integer not null,
	ativo boolean,
	sexo varchar(15),
	templo integer,
	idade integer,
	turma varchar(30) not null,
	matricula_escola_biblica boolean,
	capacitacao_concluido boolean,
	matricula_lider boolean,
	rua varchar(50),
	numero integer,
	bairro varchar(30),
	cidade varchar(30),
	uf varchar(3),
	cep varchar(9),
	complemento varchar(10),
	celular varchar(15),
	fixo varchar(15),
	email varchar(30),
	whatsaap varchar(3),
	CONSTRAINT id_membro PRIMARY KEY(id_membro),
	FOREIGN KEY (ministerio) REFERENCES ministerio(id_ministerio),
	FOREIGN KEY (templo) REFERENCES templo (id_templo)
	);
	
	insert into membro(nome_membro,cpf,rg,batizado,dt_nasc,ministerio,ativo,sexo,templo,idade,turma,matricula_escola_biblica,capacitacao_concluido,
						matricula_lider,rua,numero,bairro,cidade,uf,cep,celular,fixo,email,whatsaap)
	values('Everson Borges','04284334646','MG-10.374.064','Sim','1981-10-18',1,false,'Masculino',1,37,'Adultos',true,true,true,'Rua 2',432,'Petropolis','Betim',
			'MG','32681-405','31 988772043',null,'everson.cursos@gmail.com','Sim');
	
	insert into membro(nome_membro,cpf,rg,batizado,dt_nasc,ministerio,ativo,sexo,templo,idade,turma,matricula_escola_biblica,capacitacao_concluido,
						matricula_lider,rua,numero,bairro,cidade,uf,cep,celular,fixo,email,whatsaap)
	values('Edson Borges','04679629606','MG-10.374.064','Sim','1981-10-18',1,false,'Masculino',1,37,'Adultos',true,true,true,'Rua 2',432,'Petropolis','Betim',
			'MG','32681-405','31 988772043',null,'everson.cursos@gmail.com','Sim');
	
	insert into membro(nome_membro,cpf,rg,batizado,dt_nasc,ministerio,ativo,sexo,templo,idade,turma,matricula_escola_biblica,capacitacao_concluido,
						matricula_lider,rua,numero,bairro,cidade,uf,cep,celular,fixo,email,whatsaap)	
	values('Patricia Borges','10240641663','MG-10.374.064','Sim','1981-10-18',1,false,'Feminino',1,37,'Adultos',true,true,true,'Rua 2',432,'Petropolis','Betim',
			'MG','32681-405','31 988772043',null,'everson.cursos@gmail.com','Sim');