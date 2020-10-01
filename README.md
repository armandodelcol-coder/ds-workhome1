# DS-WORKHOME1

## Trabalho final do capítulo

Projeto para consolidar o aprendizado do capítulo 1 do Bootcamp Java com React da DevSuperior.

### Enunciado do trabalho

Você deverá entregar um projeto Spring Boot 2.3.x contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:

- Busca paginada de recursos
- Busca de recurso por id
- Inserir novo recurso
- Atualizar recurso
- Deletar recurso

O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar Maven como gerenciador de dependência, Java 11 como linguagem.

Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da entidade Client é mostrada a seguir (você deve seguir à risca os nomes de classe e atributos mostrados no diagrama):

-------------------------
class Client
 - id: Long
 - name: String
 - cpf: String
 - income: Double
 - birthDate: Instant
 - children: Integer
-------------------------

### Tecnologias/Ferramentas

- Java JDK11
- Spring Boot 2.3.4
- Maven
- JPA
- H2

- IDE: IntelliJ Community Edition
- REST tests: Insomnia

### Testando no Postman/Insomnia

Buscar paginada de clientes:

`GET /clients?page=0&linesPerPage=12&direction=ASC&orderBy=name`

Buscar de cliente por id:

`GET /clients/1`

Inserção de novo cliente:

`POST /clients`:
```js
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

Atualização de cliente:

`PUT /clients/1`:
```js
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

Deleção de cliente:

`DELETE /clients/1`

