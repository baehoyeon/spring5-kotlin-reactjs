# SpringBoot2(WebFlux) Kotlin Example
This project based on kotlin, spring-boot2, mysql 

Check [my blog](https://baehoyeon.github.io/) for more details.

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
## 1. Server
### run
```
./gradlew bootRun
```

### open
```
http://localhost:19036/
```

## 2. Client
### install
```
$ cd src/main/frontend
$ npm install
```
### run
```
$ cd src/main/frontend
## watch
$ npm run watch

## build dev
$ npm run dev-build

## build prod
$ npm run prod-build
```