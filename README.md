
# Wheather - Sistema que cadastra cidades e traz suas temperaturas dos últimos 5 dias!
Este projeto faz integração com a API [OpenWheatherMap](https://openweathermap.org/api) para retornar o cima das cidades.

## Técnologias utilizadas

### Frontend
* [Angular](https://angular.io/)
* [Angular Cli](https://cli.angular.io/)
* [Bootstrap](https://getbootstrap.com/)
* [Nodejs](https://nodejs.org/en/)
* [Npm](https://www.npmjs.com/)

### Backend
* [Java](https://java.com/en/download/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [H2 batabase](http://www.h2database.com/html/main.html)
* [Flyway](https://flywaydb.org/)
* [PostgreSQL](https://www.postgresql.org/download/)
* [Maven](https://maven.apache.org/)

## Executando a aplicação

1. Como pré-requisito, possuir [docker](https://www.docker.com/).
2. Baixar o arquivo docker-compose.yml deste repositório e executar o comando: docker-compose up.

> Será baixada a imagem do banco de dados e da aplicação, onde a mesma ficará disponível na porta 8080.
> A aplicação frontend ficará disponível em localhost:4200.
> Importante: A imagem do banco de dados que o docker irá iniciar utiliza a porta 5432, fica imprescindível ter esta porta disponível ao iniciar a orquestragem dos containers.

> Para rodar a aplicação localmente, há a necessidade de passar as inforações da base de dados, conforme exemplo:
```
-DDB_HOST=jdbc:postgresql://localhost:5432/wheather
-DDB_USER=postgres
-DDB_PASSWORD=postgres
```

### API's disponíveis
* [Wiki do projeto](https://github.com/aliniribeiroo/wheather/wiki/API's)
