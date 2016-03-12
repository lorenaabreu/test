CREATE TABLE FUNCIONARIO(
    id INT NOT NULL auto_increment, 
    nome VARCHAR(50) NOT NULL,
    data_contratacao DATE NOT NULL,
    salario DOUBLE NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    mes_preferencia VARCHAR(20) NOT NULL,
    ctps VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);