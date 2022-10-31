DROP DATABASE IF EXISTS mt_logistica;
create database mt_logistica;
use mt_logistica;
show tables;

create table usuario(
	id int NOT NULL auto_increment,
	nome varchar(150),
    email varchar(150) not null unique,
    senha varchar(50) not null,
    nivel int unsigned not null default '1',
    
    primary key (id)
);
insert into usuario(nome, email, senha, nivel)
values("joao", "joaomelo_9@hotmail.com", "teste", 1);
/*  valores pela vpn em nuvem (AWM)*/

INSERT INTO usuario (nome, email, senha, nivel) VALUES('Teste','teste@teste.com','teste', 0);
INSERT INTO usuario (nome, email, senha, nivel) VALUES('Teste2','teste2@teste.com','teste', 1);

create table motorista(
	id int auto_increment,
    nome varchar(150) unique ,
    telefone varchar(20) not null,
    
    primary key(id)
);

create table veiculo(
	placa varchar(7),
    tipo_veiculo varchar(60),
    
    primary key(placa)
);

create table cliente(
	id int auto_increment,
    cnpj varchar(14) unique,
    nome_fantasia varchar(250),
    endereco varchar(250),
    uf varchar(2),
    cidade varchar(70),
    ddd varchar(2) ,
    telefone varchar(12) unique ,
    email varchar(150) unique not null,
    
    primary key(id)
);

create table estatus(
id int auto_increment,
estatus int,
placa varchar(7),
motorista int,
destinatario int unique,

primary key(id),
foreign key (placa) references veiculo(placa),
foreign key (motorista) references motorista(id),
foreign key (destinatario) references cliente(id)
);

create table evento(
	id int auto_increment,
    data_inser timestamp default current_timestamp,
    evento varchar(50),
    
    primary key(id)
);

insert into motorista(nome, telefone)
values("Joao Vito", "15991728561"),
("Vinicius", "15991759567"),
("Matheus", "15548125658"),
("Eduardo", "15897662531");

insert into veiculo(placa, tipo_veiculo)
values("FKL2F21", "Caminhão"),
("DFL2F87", "Caminhão");

insert into cliente(cnpj, nome_fantasia, endereco, uf, cidade, ddd, telefone, email)
values("05454606000110", "Froth Jardim", "Rod antonio romano Schink, S/n", "SP", "Cerquilho", "15", "1532823444", "logistica@forthjardim.com.br"),
("05454606050110", "Froth Jardim", "Rod antonio romano Schink, S/n", "SP", "Cerquilho", "15", "1532223444", "istica@forthjardim.com.br");

-- quantidade de logs realizados
-- gatilho especificado em tempo real
/*
	Objetivo: alimentar as tabelas relacionadas ao gatilho, 
*/

/*________________ VIWS________________*/
 create view clientes as
	select * from cliente;
select  *  from clientes;

create view Usuarios as 
	select * from usuario;
;select * from Usuarios;

create view Veiculos as 
	select * from veiculo
;select * from Veiculos;

/*________________ TRIGGER ________________*/
-- trigger "gatilho de conhecimento de parainserção de maior valor
-- deixe der ser mais que comum n"

delimiter $
create trigger TriggerT -- nome do gatilho especificado 
	after insert -- clausula para especificar o tempo para invocar o gatilho 
    on veiculo for each row
    begin
		insert into evento(evento)
        values("disparos");
    end$
delimiter ;

/*
gatilho = trigger,l false procedurer        
sintaxe basica da criação de um after, false case diferente de aumentar o valor 
*/