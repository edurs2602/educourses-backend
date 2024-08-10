# EduCourses

EduCourses é uma aplicação web para criar e responder perguntas de maneira interativa. O projeto foi desenvolvido usando Spring Boot para o backend e PostgreSQL como banco de dados.

## Funcionalidades

- **Autenticação e Autorização**: Implementado com Spring Security, suportando diferentes níveis de acesso (admin).
- **CRUD de Perguntas e Respostas**: Gerenciamento completo de perguntas e respostas através de APIs RESTful.
- **Documentação com Swagger**: A documentação da API é gerada automaticamente usando Springdoc OpenAPI.
- **Integração com PostgreSQL**: Banco de dados PostgreSQL configurado e acessível via Docker.
- **Configuração de Segurança**: Implementação de autenticação básica e autorização baseada em papéis.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.2**
- **Spring Security**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker**
- **Springdoc OpenAPI**

## Requisitos

- Docker e Docker Compose instalados na máquina.
- Java 21 instalado para desenvolvimento local.

## Como Rodar a Aplicação com Docker

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/educourses.git
cd educourses
```

## Rodar o Docker Compose

- O projeto está configurado para rodar com Docker usando um arquivo docker-compose.yml. O PostgreSQL está configurado para rodar na porta 5434 para evitar conflitos com outras instâncias.

## Executar a Aplicação com Docker Compose

Para iniciar a aplicação, execute o seguinte comando na raiz do projeto:

```bash
sudo docker-compose up --build
```

Este comando irá:

- Construir a imagem Docker para a aplicação Spring Boot.
- Iniciar um container para o PostgreSQL configurado.
- Iniciar a aplicação Spring Boot, que estará acessível na porta 8080.

## Acessar a Aplicação

Após iniciar os containers, a aplicação estará disponível em:

- API Base: http://localhost:8080
- Documentação Swagger: http://localhost:8080/swagger-ui.html

## Encerrar os Containers
Para parar os containers, execute:

```bash
sudo docker-compose down
```

## Configuração de Segurança

A segurança é gerenciada pelo Spring Security. O acesso às APIs é restrito, e apenas usuários autenticados podem fazer requisições. O usuário padrão criado para testes é:

- Usuário: admin
- Senha: password

## Contribuição

Se quiser contribuir com o projeto, sinta-se à vontade para abrir um pull request ou relatar problemas na seção de Issues.
