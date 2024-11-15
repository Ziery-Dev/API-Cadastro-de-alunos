# API RESTful para Cadastro de Alunos

API RESTful para gerenciamento de alunos, construída com Spring Boot, JPA e MySQL. A API implementa operações básicas de CRUD e segue uma arquitetura em camadas para maior organização e modularidade.

## Estrutura do Projeto

- **Entidade (Aluno):** Representa o modelo de dados que mapeia a tabela `TB_ALUNOS` no banco de dados.
- **Repositório (AlunoRepository):** Interface responsável pelas operações de acesso ao banco de dados.
- **Serviço (AlunoService):** Contém a lógica de negócios e gerencia o fluxo de dados entre o repositório e o controlador.
- **Controlador (AlunoController):** Exponibiliza os endpoints REST e define as rotas HTTP.
- **DTO (AlunoDto):** Define validações para os dados recebidos e simplifica a manipulação de informações.
- **Tratamento de Exceções (GlobalExceptionHandler):** Centraliza e personaliza as mensagens de erro da aplicação.

## Principais Funcionalidades

- **Validações:** Uso de anotações como `@NotBlank` e `@Positive` no DTO para garantir a integridade dos dados.
- **Matrícula Única:** Atributo `matricula` definido como único no banco de dados.
- **Conversão DTO ↔ Entidade:** Uso do `BeanUtils` para facilitar a conversão de dados entre `AlunoDto` e `Aluno`.
- **Filtros Personalizados:** Permite buscar alunos por curso.

## Tecnologias Utilizadas

- **Spring Boot:** Framework para desenvolvimento rápido de APIs RESTful.
- **JPA/Hibernate:** Mapeamento objeto-relacional para persistência de dados.
- **MySQL:** Banco de dados relacional utilizado para armazenamento.
- **Jakarta Validation:** Validação dos dados recebidos via DTO.

## Endpoints da API

| Método  | Endpoint              | Descrição                                |
|---------|-----------------------|------------------------------------------|
| `POST`  | `/alunos`             | Criação de um novo aluno.                |
| `GET`   | `/alunos`             | Listagem de todos os alunos.             |
| `GET`   | `/alunos/{id}`        | Consulta de um aluno específico.         |
| `PUT`   | `/alunos/{id}`        | Atualização de informações de um aluno.  |
| `DELETE`| `/alunos/{id}`        | Exclusão de um aluno.                    |
| `GET`   | `/alunos/curso/{curso}` | Filtragem de alunos por curso.           |

## Exceções Tratadas

- **ResourceNotFoundException:** Retorna uma mensagem personalizada quando o aluno não é encontrado.
- **DataIntegrityViolationException:** Garante que dados duplicados (ex.: matrícula) não sejam salvos.
- **MethodArgumentNotValidException:** Lida com erros de validação do DTO.
- **Erro Genérico:** Mensagens de erro personalizadas para exceções inesperadas.

---

Essa API foi projetada para oferecer um gerenciamento eficiente de alunos, utilizando práticas modernas de desenvolvimento em Spring Boot.
