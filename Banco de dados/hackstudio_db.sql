CREATE DATABASE hackstudio_db;

CREATE TABLE funcionarios(
    id int AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    sobrenome varchar(50) NOT NULL,
    email varchar(40) NOT NULL,
    passwd varchar(300) NOT NULL,
    salt varchar(300) NOT NULL,
    estado boolean NOT NULL DEFAULT TRUE,
    admin_level boolean NOT NULL DEFAULT FALSE,
    
    CONSTRAINT UC_email
        UNIQUE (email),
    
    CONSTRAINT PK_ID
        PRIMARY KEY (id)
);

CREATE TABLE clientes(
    id int AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    email varchar(40) NOT NULL,
    cpf varchar(11) NOT NULL,
    telefone varchar(11) NOT NULL,
    facebook varchar(50),
    instagram varchar(50),
    
    CONSTRAINT PK_ID
        PRIMARY KEY (id),

    CONSTRAINT UC_CPF 
        UNIQUE (cpf)
)ENGINE=InnoDB;

CREATE TABLE tatuadores(
    id int AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    email varchar(40) NOT NULL,
    cpf varchar(11) NOT NULL,
    endereco varchar(50) NOT NULL,
    telefone varchar(11) NOT NULL,
    facebook varchar(50) NOT NULL,
    instagram varchar(50) NOT NULL,
    especialidade varchar(20) NOT NULL,

    CONSTRAINT PK_ID
        PRIMARY KEY (id),

    CONSTRAINT UC_CPF
        UNIQUE (cpf)
);

CREATE TABLE agendamentos(
    id int AUTO_INCREMENT,
    data varchar(10) NOT NULL,
    horario varchar(5) NOT NULL,
    preco double(5,2) NOT NULL,
    fk_id_cliente int,
    fk_id_tatudor int,
    
    CONSTRAINT FK_CPF_CLIENTE 
        FOREIGN KEY (fk_id_cliente)
        REFERENCES clientes(cpf),

    CONSTRAINT FK_ID_TATUADOR
        FOREIGN KEY (fk_id_tatudor)
        REFERENCES tatuadores(id),
    
    CONSTRAINT PK_ID
        PRIMARY KEY (id)
);

CREATE TABLE estoque(
    id int AUTO_INCREMENT,
    nome varchar(40) NOT NULL,
    quantidade int(3) NOT NULL,
    valor_unitario double(5,2) NOT NULL,

    CONSTRAINT PK_ID
        PRIMARY KEY (id)
);