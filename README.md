# 📚 Biblioteca API

API REST para gerenciamento de uma biblioteca, desenvolvida com Java e Spring Boot seguindo boas práticas de arquitetura em camadas.

---

## 🚀 Tecnologias

- **Java 21**
- **Spring Boot 4**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database**
- **Maven**

---

## 🏗️ Arquitetura

O projeto segue o padrão de arquitetura em camadas:

```
src/main/java/com/gabriel/biblioteca/
├── controller/       → Recebe as requisições HTTP
├── service/          → Contém as regras de negócio
├── repository/       → Comunicação com o banco de dados
├── model/            → Entidades JPA
└── exception/        → Tratamento global de erros
```

---

## 📋 Endpoints

### 📖 Livros

| Método | URL | Descrição | Status |
|--------|-----|-----------|--------|
| `GET` | `/livros/{id}` | Busca livro por ID | 200 |
| `POST` | `/livros` | Cadastra um novo livro | 201 |
| `PUT` | `/livros/{id}` | Atualiza um livro | 200 |
| `DELETE` | `/livros/{id}` | Remove um livro | 204 |

### 🗂️ Categorias

| Método | URL | Descrição | Status |
|--------|-----|-----------|--------|
| `GET` | `/categorias/{id}` | Busca categoria por ID | 200 |
| `POST` | `/categorias` | Cadastra uma nova categoria | 201 |
| `PUT` | `/categorias/{id}` | Atualiza uma categoria | 200 |
| `DELETE` | `/categorias/{id}` | Remove uma categoria | 204 |

---

## 📦 Exemplos de uso

### Cadastrar um livro

**Request**
```http
POST /livros
Content-Type: application/json

{
  "nome": "Clean Code",
  "autor": "Robert C. Martin",
  "preco": 89.90,
  "anoPublicacao": 2008
}
```

**Response** `201 Created`
```json
{
  "id": 1,
  "nome": "Clean Code",
  "autor": "Robert C. Martin",
  "preco": 89.9,
  "anoPublicacao": 2008
}
```

### Buscar um livro

**Request**
```http
GET /livros/1
```

**Response** `200 OK`
```json
{
  "id": 1,
  "nome": "Clean Code",
  "autor": "Robert C. Martin",
  "preco": 89.9,
  "anoPublicacao": 2008
}
```

### Livro não encontrado

**Request**
```http
GET /livros/999
```

**Response** `404 Not Found`
```
Livro de id 999 não encontrado
```

---

## ⚙️ Como executar

### Pré-requisitos

- Java 21
- Maven

### Passos

1. Clone o repositório
```bash
git clone https://github.com/Gabriel07-br/biblioteca.git
```

2. Acesse a pasta do projeto
```bash
cd biblioteca
```

3. Execute a aplicação
```bash
./mvnw spring-boot:run
```

4. A API estará disponível em:
```
http://localhost:8080
```

---

## 🗄️ Banco de dados

O projeto utiliza o **H2 Database** — um banco de dados em memória que é iniciado automaticamente junto com a aplicação. Os dados são resetados a cada reinicialização.

---

## 👨‍💻 Autor

Feito por **Gabriel** — em desenvolvimento contínuo 🚀
