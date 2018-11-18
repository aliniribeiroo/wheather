
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

Backend - Há a necessidade de passar as inforações da base de dados, conforme exemplo:
```
-DWHEATHER_DB_HOST=jdbc:postgresql://localhost:5432/wheather
-DWHEATHER_DB_USER=postgres
-DWHEATHER_DB_PASSWORD=postgres
** é preciso criar uma base de dados
```
Frontend - dentro do diretório wheather-frontend executar os comandos:
```
npm install
npm start
```

### API's disponíveis
* [Wiki do projeto](https://github.com/aliniribeiroo/wheather/wiki/API's)
