-- Inserir dados na tabela cliente
INSERT INTO cliente (nome, email, telefone, endereco) VALUES
('João Silva', 'joao.silva@example.com', '123456789', 'Rua A, 123'),
('Maria Oliveira', 'maria.oliveira@example.com', '987654321', 'Avenida B, 456');

-- Inserir dados na tabela servico
INSERT INTO servico (nome, descricao, preco, duracao_estimada) VALUES
('Reparo de Computador', 'Reparo de hardware e software', 150.00, 2),
('Manutenção de Impressora', 'Limpeza e ajustes', 80.00, 1);

-- Inserir dados na tabela ordem_de_servico
INSERT INTO ordem_de_servico (cliente_id, servico_id, data_inicio, data_termino, status) VALUES
(1, 1, '2024-07-01', '2024-07-02', 'Concluído'),
(2, 2, '2024-07-05', '2024-07-06', 'Em Andamento');
