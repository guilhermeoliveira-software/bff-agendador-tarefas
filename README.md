# 📅 Ecossistema Agendador de Tarefas (Arquitetura BFF)

Este projeto implementa um **ecossistema de microserviços para gerenciamento e agendamento de tarefas**, utilizando o padrão **BFF (Backend For Frontend)** para centralizar a comunicação entre clientes e serviços internos.

O sistema foi desenvolvido com foco em **boas práticas de arquitetura backend**, incluindo separação de responsabilidades, comunicação entre serviços e otimização de performance com cache.

---

# 🧩 Arquitetura do Sistema

O sistema é composto por três serviços principais:

### 1️⃣ BFF (Backend For Frontend)

Responsável por centralizar as requisições do cliente e orquestrar a comunicação com os serviços internos.

Funções principais:

- Centralização de endpoints
- Orquestração entre serviços
- Simplificação da comunicação com o frontend

---

### 2️⃣ Serviço de Agendamento

Responsável por gerenciar o ciclo de vida das tarefas.

Funcionalidades:

- Criar tarefas
- Atualizar tarefas
- Listar tarefas
- Remover tarefas
- Cache de consultas utilizando Redis

---

### 3️⃣ Serviço de Notificação

Responsável por enviar notificações relacionadas às tarefas.

Exemplo:

- envio de notificações por email
- alertas de tarefas agendadas

---

# 🏗️ Arquitetura

O projeto utiliza princípios inspirados em **Arquitetura Hexagonal (Ports and Adapters)** para separar domínio, aplicação e infraestrutura.

Estrutura geral:

Controller
↓
Service
↓
Repository
↓
Database / Cache

---

# ⚙️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Redis
- Docker
- REST APIs

---

# 📦 Infraestrutura

O projeto pode ser executado utilizando containers com Docker.

Cada serviço roda de forma independente, permitindo escalabilidade e isolamento entre componentes do sistema.

---

# 🚀 Como Executar o Projeto

### Pré-requisitos

- Java 17+
- Docker
- Git

---
### 1️⃣ Clonar o repositório
git clone https://github.com/guilhermeoliveira-software/bff-agendador-tarefas.git

---
### 2️⃣ Entrar no diretório
cd bff-agendador-tarefas

---
### 3️⃣ Subir os serviços
docker-compose up --build


---
# 📡 Exemplo de Fluxo de Requisição

1. Cliente envia requisição para o BFF
2. BFF processa a requisição
3. BFF chama o serviço de agendamento
4. Serviço consulta banco ou cache Redis
5. Caso necessário, aciona serviço de notificação

---
# 📚 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de:

- praticar desenvolvimento backend com microserviços
- aplicar boas práticas de arquitetura
- trabalhar com cache distribuído
- implementar comunicação entre serviços

---
# 👨‍💻 Autor

José Guilherme da Costa Oliveira

LinkedIn:
https://www.linkedin.com/in/guilherme-costa-139a63341/

GitHub:
https://github.com/guilhermeoliveira-software

