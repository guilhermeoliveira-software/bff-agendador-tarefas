# 📅 Ecossistema Agendador de Tarefas (Arquitetura BFF)

## Descrição

Este projeto implementa um **ecossistema de microserviços para gerenciamento e agendamento de tarefas**, utilizando o padrão **BFF (Backend For Frontend)** para centralizar a comunicação entre clientes e serviços internos. O sistema foi desenvolvido com foco em **boas práticas de arquitetura backend**, incluindo separação de responsabilidades, comunicação entre serviços e otimização de performance com cache.

## Arquitetura do Sistema

O sistema é composto por três serviços principais, orquestrados para funcionar de forma coesa:

### 1️⃣ BFF (Backend For Frontend)

Responsável por centralizar as requisições do cliente e orquestrar a comunicação com os serviços internos. Suas funções principais incluem:

*   **Centralização de Endpoints**: Agrega diversas APIs de backend em um único ponto de acesso para o frontend.
*   **Orquestração entre Serviços**: Gerencia o fluxo de dados e chamadas entre os microserviços de agendamento e notificação.
*   **Simplificação da Comunicação**: Reduz a complexidade do frontend ao interagir com múltiplos serviços, adaptando as respostas às necessidades específicas da interface.

### 2️⃣ Serviço de Agendamento

Responsável por gerenciar o ciclo de vida das tarefas, oferecendo as seguintes funcionalidades:

*   **Criação de Tarefas**: Permite o registro de novas tarefas com detalhes como data, hora e descrição.
*   **Atualização de Tarefas**: Possibilita a modificação de tarefas existentes.
*   **Listagem de Tarefas**: Fornece mecanismos para consultar e filtrar tarefas agendadas.
*   **Remoção de Tarefas**: Permite a exclusão de tarefas do sistema.
*   **Cache de Consultas**: Utiliza **Redis** para otimizar o desempenho de consultas frequentes, reduzindo a carga sobre o banco de dados.

### 3️⃣ Serviço de Notificação

Responsável por enviar notificações relacionadas às tarefas agendadas. Exemplos de notificações incluem:

*   **Envio de E-mails**: Notificações por e-mail para alertar sobre tarefas próximas ou concluídas.
*   **Alertas de Tarefas Agendadas**: Outros tipos de alertas configuráveis para manter os usuários informados.

## Tecnologias Utilizadas

As principais tecnologias e ferramentas utilizadas neste ecossistema incluem:

*   **Java 17**: Linguagem de programação principal.
*   **Spring Boot**: Framework para construção de aplicações Java robustas e eficientes.
*   **Spring Security**: Para autenticação e autorização, garantindo a segurança das APIs.
*   **Spring Data JPA**: Para persistência de dados e interação com o banco de dados.
*   **Spring Cloud OpenFeign**: Para comunicação declarativa e resiliente entre os microserviços.
*   **Redis**: Utilizado como cache distribuído para otimização de performance.
*   **Docker**: Para conteinerização de todos os serviços, facilitando o desenvolvimento e a implantação.
*   **REST APIs**: Padrão de comunicação para as interfaces dos serviços.
*   **Maven**: Ferramenta de automação de build.

## Estrutura do Projeto

A estrutura do projeto segue as convenções de um projeto Spring Boot, com pacotes organizados por funcionalidade e inspirados na Arquitetura Hexagonal (Ports and Adapters):

```
src/
├── main/
│   ├── java/
│   │   └── com/costadev/bffagendadortarefas/
│   │       ├── business/             # Lógica de negócio e serviços
│   │       ├── controller/           # Controladores REST e endpoints do BFF
│   │       └── infrasctruture/       # Configurações de infraestrutura e exceções
│   └── resources/            # Arquivos de configuração e templates
├── test/
│   └── java/
│       └── com/costadev/bffagendadortarefas/ # Testes unitários e de integração
└── ...
```

## Como Executar o Projeto

Para executar o ecossistema completo localmente, siga os passos abaixo:

1.  **Pré-requisitos**:
    *   Java Development Kit (JDK) 17 ou superior.
    *   Docker e Docker Compose instalados.
    *   Git.

2.  **Clonar o repositório**:

    ```bash
    git clone https://github.com/guilhermeoliveira-software/bff-agendador-tarefas.git
    cd bff-agendador-tarefas
    ```

3.  **Subir os serviços com Docker Compose**:

    ```bash
    docker-compose up --build
    ```

    Este comando irá construir as imagens Docker para cada serviço (BFF, Agendador e Notificação), iniciar os contêineres e configurar as dependências (como o Redis e o banco de dados). A aplicação BFF estará disponível em `http://localhost:8080`.

## Exemplo de Fluxo de Requisição

Um fluxo típico de requisição no ecossistema ocorre da seguinte forma:

1.  **Cliente envia requisição para o BFF**: O frontend (ou outro cliente) faz uma chamada para um endpoint exposto pelo BFF.
2.  **BFF processa a requisição**: O BFF recebe a requisição, realiza validações e pré-processamentos necessários.
3.  **BFF chama o Serviço de Agendamento**: O BFF se comunica com o Serviço de Agendamento para realizar operações relacionadas a tarefas.
4.  **Serviço de Agendamento consulta banco ou cache Redis**: O Serviço de Agendamento verifica o cache Redis para dados recentes ou consulta o banco de dados para informações persistidas.
5.  **Caso necessário, aciona Serviço de Notificação**: Se a operação exigir, o Serviço de Agendamento pode acionar o Serviço de Notificação para enviar alertas ou e-mails.

## Objetivo do Projeto

Este projeto foi desenvolvido com os seguintes objetivos educacionais e práticos:

*   **Praticar Desenvolvimento Backend com Microsserviços**: Experiência na construção e gestão de múltiplas aplicações interconectadas.
*   **Aplicar Boas Práticas de Arquitetura**: Implementação de padrões como BFF e princípios da Arquitetura Hexagonal.
*   **Trabalhar com Cache Distribuído**: Utilização do Redis para otimização de performance e escalabilidade.
*   **Implementar Comunicação entre Serviços**: Uso de OpenFeign para comunicação eficiente e robusta entre os microserviços.


## Autor

José Guilherme da Costa Oliveira
