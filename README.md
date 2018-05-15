# SpringBoot2(WebFlux) Kotlin Example
This project based on kotlin, spring-boot2, mysql 

## install
### mysql
[mysql website](https://dev.mysql.com/downloads/mysql/)
### application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/spring_kotlin_example
spring.datasource.username=root
spring.datasource.password=
```
### SCHEMA
```
$ mysql -uroot -p
CREATE SCHEMA `spring_kotlin_example` DEFAULT CHARACTER SET utf8 ;

```

## Usage
### run
```
./gradlew bootRun
```

### open
```
http://localhost:19036/
```