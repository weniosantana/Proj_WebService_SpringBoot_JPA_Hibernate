
# Documentação da API

API Web Service utilizando Spring Boot e JPA, Hibernate e SQL . Esta API fornece acesso a recursos específicos e permite a manipulação de dados como usuário, produtos, pedidos e categorias de produtos através de operações CRUD (Create, Read, Update, Delete).

## Exemplos:

### Exemplo: Usuários

#### Endpoint: `http://localhost:8080/users`

**Métodos permitidos:**

-   **GET:** Obter todos os usuários do banco de dados retornando um JSON.
-   **POST:** Criar um novo usuário.
-   **PUT:** Atualizar informações de um usuário existente.
-   **DELETE:** Excluir um usuário.

#### Parâmetros de Requisição:

-   **GET:** Nenhum parâmetro adicional necessário.
-   **POST e PUT:** JSON contendo os detalhes do usuário a ser criado ou atualizado.

#### Exemplos utilizando Postman:

1.  **Obter todos os usuários (GET):**

![Get](https://github.com/weniosantana/WebService_SpringBoot/assets/61487102/409b8440-b046-4eb3-a63e-b538f2aac628)

    
2.  **Criar um novo usuário (POST):**
    
![Post](https://github.com/weniosantana/WebService_SpringBoot/assets/61487102/1cbce0f1-fbc6-4056-ac28-d27b63717c52)

    
3.  **Atualizar informações de um usuário existente (PUT):**
    
![Put](https://github.com/weniosantana/WebService_SpringBoot/assets/61487102/f2712733-cce1-4d27-a499-b6e59057c8f2)

    
4.  **Excluir um usuário (DELETE):**
    
![Get_antes_delete](https://github.com/weniosantana/WebService_SpringBoot/assets/61487102/7269f6ae-5108-4de3-a79a-5e2fd6f40a73) ![Delete](https://github.com/weniosantana/WebService_SpringBoot/assets/61487102/21efa19c-ad3f-47f3-a3f9-0be586f1a067)![Get_depois_delete](https://github.com/weniosantana/WebService_SpringBoot/assets/61487102/86940932-88b4-4cf7-adde-23fa1748f856)




## Respostas da API

As respostas da API seguem o padrão HTTP, incluindo códigos de status e corpos de resposta. Consulte a tabela abaixo para entender as respostas comuns.

Código de Status

Significado

Exemplo de Corpo de Resposta

200 OK

Requisição bem-sucedida

`{ "message": "Operação realizada com sucesso." }`

201 Created

Recurso criado com sucesso

`{ "id": 123, "message": "Usuário criado com sucesso." }`

204 No Content

Sucesso, sem conteúdo

Nenhum corpo de resposta

400 Bad Request

Requisição inválida

`{ "error": "Parâmetros inválidos." }`

404 Not Found

Recurso não encontrado

`{ "error": "Usuário não encontrado." }`

500 Internal Server Error

Erro interno do servidor

`{ "error": "Erro interno do servidor." }`

----------
