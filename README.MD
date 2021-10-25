# MovieMark

A clone of [Kinopoisk](kinopoisk.ru). Made using Spring Boot, Spring Data Rest and Spring Security.

## Data model

![Model](/img/Model.png "Model")

## Properties structure

For running this application you need to create properties file in src/main/resources/application.yaml

```yaml
spring:
  datasource:
    url: jdbc:database://url
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: user 
    password: password #  This password used only as example, always use password generators!
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: on #  For logging SQL queries
    database: mysql 
  data:
    rest: #  parameters of Spring Data REST
      max-page-size: 100
      default-page-size: 10
      return-body-on-update: off
jwt: #  Parameters of JWT generator 
  secret: 3byyDlWfqKJtXuO4V3UYmMnl9fLFf1FlIhYOEXNqLWHFvxZEISgXjDOGGnt66jZ
  expiration: 604800
  header: Authorization

```

### Data base

In this project MySQL was used. For using your own, change database connector dependency in [pom.xml](pom.xml) and
change database properties in [application.yaml](src/main/resources/application.yaml).

Swagger url: http://localhost:8080/swagger-ui/#/

## Links

### Tools

- Generate secret key: https://www.grc.com/passwords.htm
- Hashing password: https://bcrypt-generator.com/

### Docs

- [Spring Security Reference documentation](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)
- [Spring Data REST Reference documentation](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#reference)
- [Spring Security Basic Authentication guide](https://www.baeldung.com/spring-security-basic-authentication)
- [Spring Boot Security Authentication with JPA, Hibernate and MySQL](https://www.codejava.net/frameworks/spring-boot/spring-boot-security-authentication-with-jpa-hibernate-and-mysql)
- [Base principles of using Spring Security video course by Eugene Suleimanov (ru)](https://www.youtube.com/watch?v=7uxROJ1nduk)