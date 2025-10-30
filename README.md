# Controle de Gastos

Projeto em **Java com Spring Boot** para gerenciar **categorias** e **despesas**, com CRUD completo, tratamento de exceções e relacionamento entre entidades.

---

## 🛠 Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Insomnia (testes)

---

## 📂 Estrutura do projeto
| Pacote | Descrição |
|--------|-----------|
| `entity` | Classes `Categoria` e `Despesa` |
| `repository` | Interfaces JPA para persistência |
| `controller` | Endpoints REST CRUD |
| `exceptions` | Exceções personalizadas e handler global |

---

## ⚡ Endpoints da API

### Categoria

| Método | Endpoint | Descrição | Status esperado |
|--------|---------|-----------|----------------|
| GET | /categorias | Lista todas as categorias | 200 OK |
| GET | /categorias/{id} | Busca categoria por ID | 200 OK / 404 Not Found |
| POST | /categorias | Cria nova categoria | 201 Created |
| PUT | /categorias/{id} | Atualiza categoria | 200 OK / 404 Not Found |
| DELETE | /categorias/{id} | Remove categoria | 204 No Content / 404 Not Found |

### Despesa

| Método | Endpoint | Descrição | Status esperado |
|--------|---------|-----------|----------------|
| GET | /despesas | Lista todas as despesas | 200 OK |
| GET | /despesas/{id} | Busca despesa por ID | 200 OK / 404 Not Found |
| POST | /despesas | Cria nova despesa | 201 Created |
| PUT | /despesas/{id} | Atualiza despesa | 200 OK / 404 Not Found |
| DELETE | /despesas/{id} | Remove despesa | 204 No Content / 404 Not Found |

---
## 🧪 Exemplos de JSON

```json
**Categoria**

{
    "nome": "Lazer"
}

**Despesa**

**Observação**
O id da categoria deve existir previamente. Crie a categoria via POST /categorias antes de cadastrar a despesa.

{
  "descricao": "Netflix",
  "valor": 75.40,
  "data": "2025-10-29",
  "categoria": "Lazer"
}