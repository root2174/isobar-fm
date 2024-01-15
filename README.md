# isobar-fm

Esse é o entregável do teste técnico para a DWS Brazil.

O projeto foi desenvolvido com Java 17 e Spring Boot.

O projeto expõe uma API REST para recuperar uma lista de bandas, com a possibilidade de filtrar por nome e ordenar por nome (ordem alfabética) ou por popularidade.

A API também permite recuperar uma banda específica, através do seu ID.

endpoints: http://localhost:8080/api/v1/bands e http://localhost:8080/api/v1/bands/{id}

Foi utilizado arquitetura limpa para a construção do projeto, visando a separação de responsabilidades e a facilidade de manutenção e evolução do código.

Foi utilizado o Redis para cachear a lista de bandas.

Para executar o projeto, é necessário ter o Redis instalado e rodando na porta padrão (6379) ou utilizar o docker-compose para subir o Redis.

Após isso é só executar o projeto e acessar os endpoints.

## Coisas que eu gostaria de ter feito, mas não tive tempo

- Testes unitários
- Dockerfile para o projeto
- Tornar a resposta do OpenFeign uma classe separada da entidade e mapear os campos necessários. 
