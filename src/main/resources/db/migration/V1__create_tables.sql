CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255)
);

CREATE TABLE fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(14) UNIQUE,
    cep VARCHAR(10),
    estado VARCHAR(255),
    municipio VARCHAR(255),
    logradouro VARCHAR(255),
    numero VARCHAR(20)
);

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    quantidade INT,
    valor DECIMAL(10, 2),
    id_categoria INT,
    id_fornecedor INT,
    FOREIGN KEY (id_categoria) REFERENCES categorias (id),
    FOREIGN KEY (id_fornecedor) REFERENCES fornecedor (id)
);

CREATE TABLE movimentacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_movimentacao VARCHAR(255),
    tipo_pagamento VARCHAR(255),
    id_produto INT,
    quantidade INT,
    data DATETIME,
    FOREIGN KEY (id_produto) REFERENCES produto (id)
);
