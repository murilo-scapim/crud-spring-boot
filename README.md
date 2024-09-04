# API RESTful com Spring Boot

## Descrição

API RESTful desenvolvida utilizando Spring Boot e banco de dados MySQL.

Implementa nível 3 de maturidade REST, utilizando Hateoas nos recursos.

## Para executar a aplicação:

#### Requisitos:

- Docker e Docker Compose instalados.
- JDK 17


Abra um terminal na raiz do projeto e execute o comando: `docker compose up -d`.
  

Será criado um serviço para o banco de dados MySQL.

Após, a aplicação poderá ser executada na IDE.



## Endpoints

### 1. Criar student

- **Método:** `POST`
- **Endpoint:** `/students`
- **URL:** `http://localhost:8080/api/v1/students`


**Body JSON:**

  ```json
  {
    "fullName": "John Doe",
    "age": 17,
    "grade1": 5.7,
    "grade2": 3.5
  }
  ```

**Retorno:** 201 Created

```json
  {
  "id": 1,
  "fullName": "John Doe",
  "age": 17,
  "grade1": 5.7,
  "grade2": 3.5,
  "average": 4.6,
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/v1/students/1"
    },
    "students": {
      "href": "http://localhost:8080/api/v1/students"
    }
  }
}
````


### 2. Listar students

- **Método:** `GET`
- **Endpoint:** `/students`
- **URL:** `http://localhost:8080/api/v1/students`

**Retorno:** 200 OK

```json
  [
    {
      "id": 1,
      "fullName": "John Doe",
      "age": 17,
      "grade1": 5.7,
      "grade2": 3.5,
      "average": 4.6,
      "links": [
        {
          "rel": "self",
          "href": "http://localhost:8080/api/v1/students/1"
        },
        {
          "rel": "students",
          "href": "http://localhost:8080/api/v1/students"
        }
      ]
    }
]
  ```


### 3. Listar student por studentId

- **Método:** `GET`
- **Endpoint:** `/students/{studentId}`
- **URL:** `http://localhost:8080/api/v1/students/1`


**Retorno:** 200 OK

```json
{
  "id": 1,
  "fullName": "John Doe",
  "age": 17,
  "grade1": 5.7,
  "grade2": 3.5,
  "average": 4.6,
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/v1/students/1"
    },
    "students": {
      "href": "http://localhost:8080/api/v1/students"
    }
  }
}
```

**Retorno caso student não exista:** 404 Not Found

```json
{
  "message": "Student not found"
}
```



### 4. Atualizar student

- **Método:** `PATCH`
- **Endpoint:** `/students/{studentId}`
- **URL:** `http://localhost:8080/api/v1/students/1`


**Body JSON:**

```json
{
  "age": 19,
  "grade1": 8.7,
  "grade2": 6.0
}
```

**Retorno:** 200 OK

```json
{
  "id": 1,
  "fullName": "John Doe",
  "age": 19,
  "grade1": 8.7,
  "grade2": 6.0,
  "average": 7.35,
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/v1/students/1"
    },
    "students": {
      "href": "http://localhost:8080/api/v1/students"
    }
  }
}

```


### 5. Excluir student

- **Método:** `DELETE`
- **Endpoint:** `/students/{studentId}`
- **URL:** `http://localhost:8080/api/v1/students/1`

**Retorno:** 204 No Content