-- ============================================
-- 1. CRIAÇÃO DO BANCO
-- ============================================

CREATE DATABASE loja;
GO

-- ============================================
-- 2. USAR O BANCO
-- ============================================

USE loja;
GO

-- ============================================
-- 3. CRIAÇÃO DA TABELA PRODUTO
-- ============================================

CREATE TABLE Produto (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    precoVenda FLOAT NOT NULL
);
GO

-- ============================================
-- 4. INSERÇÃO DE DADOS PARA TESTE
-- ============================================

INSERT INTO Produto (nome, quantidade, precoVenda) VALUES
('Banana', 100, 5.00),
('Maçã', 50, 3.50),
('Arroz', 30, 20.00),
('Feijão', 25, 8.50),
('Leite', 40, 6.20);
GO

-- ============================================
-- 5. CONSULTAS ÚTEIS (OPCIONAL)
-- ============================================

-- Listar todos os produtos
SELECT * FROM Produto;
GO

-- Buscar produto por ID
SELECT * FROM Produto WHERE id = 1;
GO

-- Atualizar produto
UPDATE Produto
SET nome = 'Arroz Tipo 1', precoVenda = 22.00
WHERE id = 3;
GO

-- Excluir produto
DELETE FROM Produto WHERE id = 5;
GO
