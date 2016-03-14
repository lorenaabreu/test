CREATE TABLE FUNCIONARIO(
    id INT NOT NULL auto_increment, 
    nome VARCHAR(50) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    mes_preferencia VARCHAR(20) NOT NULL,
    aceite VARCHAR(5) NOT NULL,
    ctps VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);