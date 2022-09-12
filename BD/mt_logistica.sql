DROP DATABASE IF EXISTS mt_logistica;
create database mt_logistica;
use mt_logistica;
show tables;

create table usuario(
	id int NOT NULL auto_increment,
	nome varchar(150),
    email varchar(150) not null unique,
    senha varchar(50) not null,
    nivel varchar(1) NOT NULL,
    
    primary key (id)
);

INSERT INTO usuario (nome, email, senha, nivel) VALUES('Teste','teste@teste.com','teste', 0);
INSERT INTO usuario (nome, email, senha, nivel) VALUES('Teste2','teste2@teste.com','teste', 1);

create table motorista(
	id int auto_increment,
    nome varchar(150) unique ,
    telefone varchar(20) not null,
    
    primary key(id)
);

create table veiculo(
	codigo int auto_increment,
	placa varchar(7) unique,
    tipo_veiculo varchar(60),
    
    primary key(codigo)
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