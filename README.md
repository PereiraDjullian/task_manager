# task_manager
Estudo de persistencia no mySQL

Sistema de Gerenciamento de Tarefas

📌 Sobre o Projeto

Este projeto é um sistema simples de gerenciamento de tarefas desenvolvido em Java utilizando MySQL como banco de dados. O sistema permite adicionar, listar, atualizar e excluir tarefas, bem como modificar o status de cada uma.

🛠️ Tecnologias Utilizadas

Java (JDK 11+)

MySQL (Banco de Dados Relacional)

JDBC (Java Database Connectivity)

Maven (Gerenciamento de Dependências)

📂 Estrutura do Projeto

📦 task-manager
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 br
 ┃ ┃ ┃ ┣ 📂 dio
 ┃ ┃ ┃ ┃ ┣ 📂 conexaoMySql  # Conexão com o banco de dados
 ┃ ┃ ┃ ┃ ┣ 📂 dao          # Classes de acesso ao banco (CRUD)
 ┃ ┃ ┃ ┃ ┗ 📜 Main.java     # Classe principal (MENU)
 ┣ 📜 pom.xml               # Arquivo de configuração do Maven
 ┗ 📜 README.md             # Documentação do projeto

🏗️ Configuração do Banco de Dados

Antes de rodar o sistema, é necessário configurar o banco de dados.

Abra o MySQL e crie o banco:

CREATE DATABASE task_db;
USE task_db;

Crie a tabela de tarefas:

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status ENUM('PENDING', 'IN_PROGRESS', 'DONE') DEFAULT 'PENDING'
);

🔧 Configuração do Projeto

Clone o repositório:

git clone https://github.com/seu-usuario/task-manager.git

Configure o MySQL:

Verifique que o MySQL está rodando.

Altere o usuário e senha no arquivo ConnectionMySQL.java caso necessário:

private static final String URL = "jdbc:mysql://localhost:3306/task_db";
private static final String USER = "root";
private static final String PASSWORD = "root";

Compile e execute:

mvn clean install
java -jar target/task-manager.jar

🚀 Funcionalidades

✅ Criar uma nova tarefa
✅ Listar todas as tarefas
✅ Atualizar status de uma tarefa
✅ Excluir uma tarefa
