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
    coordX double,
    coordY double,
    
    primary key(id)
);

create table estatus(
id int auto_increment,
estatus int,
placa varchar(7),
motorista int,
destinatario int,

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
("Eduardo", "15897662531"),
("Carlos Villagran","15123456789"),
("Maria Antonieta de las Nieves","15123456789"),
("Don Ramón","15123456789"),
("Roberto Bolaños","15123456789"),
("Edgar Vivar","15123456789"),
("Lineu Silva","15123456789"),
("Agostinho Carrara","15123456789"),
("Maria Isabel","15123456789"),
("Abelardo","15123456789"),
("Marilda","15123456789"),
("Floriano","15123456789"),
("Mario","15123456789"),
("Luigi","15123456789"),
("Ana","15123456789"),
("Fátima","15123456789"),
("Luciano","15123456789"),
("Fausto","15123456789"),
("Marcos","15123456789"),
("Patrícia","15123456789"),
("Monaliza","15123456789"),
("Evaristo","15123456789"),
("Antonio","15123456789");

insert into veiculo(placa, tipo_veiculo)
values("FKL2F21", "Caminhão"),
("DFL2F87", "Caminhão"),
("DKA6W24", "Caminhão"),
("KJL9K21", "Caminhão"),
("VNX4K02", "Caminhão"),
("KJR4O12", "Caminhão"),
("ZXC3N84", "Caminhão"),
("MAZ2K04", "Caminhão"),
("OWE6A53", "Caminhão"),
("MCZ5Q23", "Caminhão"),
("OKD9E23", "Caminhão"),
("KDQ4M43", "Caminhão"),
("PZC1O13", "Caminhão"),
("TFF4K13", "Caminhão"),
("GGH1B10", "Caminhão"),
("OSD5R92", "Caminhão"),
("AGH1B11", "Caminhão"),
("BGH1B12", "Caminhão"),
("CGH1B13", "Caminhão"),
("DGH1B14", "Caminhão"),
("EGH1B15", "Caminhão"),
("FGH1B16", "Caminhão"),
("HGH1B17", "Caminhão"),
("IGH1B18", "Caminhão"),
("JGH1B19", "Caminhão"),
("KGH1B10", "Caminhão"),
("LGH1B11", "Caminhão");

insert into cliente(cnpj, nome_fantasia, endereco, uf, cidade, ddd, telefone, email,coordX,coordY)
values("05454606000110", "Froth Jardim", "Rod antonio romano Schink, S/n", "SP", "Cerquilho", "15", "1532823444", "logistica@forthjardim.com.br",-23.51, -47.45),
("05454606000111", "Froth Jardim", "Rod antonio romano Schink, S/n", "SP", "Cerquilho", "15", "1532823445", "logistica@forthjardim.com.br2",-23.51, -47.4),
("05454606000112", "Froth Jardim", "Rod antonio romano Schink, S/n", "SP", "Cerquilho", "15", "1532823446", "logistica@forthjardim.com.br3",-23.51, -47.4),
("05454606000113", "Froth Jardim", "Rod antonio romano Schink, S/n", "SP", "Cerquilho", "15", "1532823447", "logistica@forthjardim.com.br4",-23.51, -47.4),
("05454606000114", "Froth Jardim", "Rod antonio romano Schink, S/n", "SP", "Cerquilho", "15", "1532823448", "logistica@forthjardim.com.br5",-23.51, -47.4),
("05454606050115", "Froth Jardim", "Rod antonio romano Schink, S/n", "SP", "Cerquilho", "15", "1532223449", "istica@forthjardim.com.br6",-23.51, -47.4);

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

-- Os inserts abaixo só funcionaram aqui no final! (ñ sei o pq)
INSERT INTO estatus (estatus, placa, motorista, destinatario) 
VALUES(1,"DFL2F87",1,1),
(2,"FKL2F21",2,1),
(4,"DFL2F87",4,2),
(1,"DKA6W24",5,3),
(2,"KJL9K21",6,3),
(3,"VNX4K02",7,4),
(4,"KJR4O12",8,4),
(1,"MAZ2K04",10,1),
(2,"OWE6A53",11,2),
(2,"MCZ5Q23",12,2),
(3,"OKD9E23",13,3),
(3,"KDQ4M43",14,3),
(4,"PZC1O13",15,4),
(1,"TFF4K13",3,4),
(5,"AGH1B11",16,5),
(5,"BGH1B12",17,5),
(5,"CGH1B13",18,5),
(1,"DGH1B14", 19,1),
(1,"EGH1B15", 20,1),
(1,"FGH1B16", 21,1),
(3,"HGH1B17", 22,2),
(3,"IGH1B18", 23,3),
(3,"JGH1B19", 24,4),
(3,"KGH1B10", 25,4),
(3,"LGH1B11", 26,4);

/*
gatilho = trigger,l false procedurer        
sintaxe basica da criação de um after, false case diferente de aumentar o valor 
*/