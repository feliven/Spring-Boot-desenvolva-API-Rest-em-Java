create table medicos(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    especialidade varchar(100) not null,
    numero_crm varchar(6) not null unique,
    endereco_email varchar(100) not null unique,
    numero_telefone varchar(20) not null,
    logradouro varchar(100) not null,
    numero_endereco varchar(20),
    complemento_endereco varchar(100),
    cidade varchar(100) not null,
    sigla_uf char(2) not null,
    cep varchar(9) not null,

    primary key(id)
);