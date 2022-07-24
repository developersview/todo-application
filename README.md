# Todo Application
- This is a To-Do App made with Spring Boot, Postgresql and Bootstrap
- Authentication has been implemented using Spring Security

[To-Do App (View Live Demo)](https://todo-app-pranoy.herokuapp.com/)

```properties
username : admin
password : 12345
```

---
### Home Page
![image](https://github.com/developersview/todo-application/blob/master/image/Screenshot%202022-07-24%20190717.png)

### Todo List View
![image](https://github.com/developersview/todo-application/blob/master/image/Screenshot%202022-07-24%20190702.png)

### Properties file for Heroku Postgresql connection 
```properties
spring.datasource.url=jdbc:postgresql://<url>:<port number>/<database name>
spring.datasource.username=
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql = true

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

## Spring view resolver set up
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

spring.security.user.name=
spring.security.user.password=

```