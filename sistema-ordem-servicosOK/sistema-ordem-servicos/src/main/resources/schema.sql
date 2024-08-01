CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(255),
    endereco VARCHAR(255)
);

CREATE TABLE servico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DOUBLE,
    duracao_estimada INT
);

CREATE TABLE ordem_de_servico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    servico_id BIGINT,
    data_inicio DATE,
    data_termino DATE,
    status VARCHAR(255),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (servico_id) REFERENCES servico(id)
);
