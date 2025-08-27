# Pedidos Java

Este proyecto es una aplicación Spring Boot para la gestión de pedidos. Utiliza MySQL como base de datos y está estructurado siguiendo buenas prácticas de desarrollo en Java.

## Requisitos
- Java 8 o superior
- Maven
- MySQL

## Configuración
Antes de ejecutar el proyecto, asegúrate de que el archivo `src/main/resources/application.properties` existe y contiene las siguientes configuraciones:

```
spring.application.name=pedidos
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update #para crear la base de datos posteriormente comentarlo
spring.jpa.show-sql=true #para ver las consultas
logging.level.org.hibernate.SQL=debug #para ver las consultas
```

Puedes modificar los valores según tu entorno local (usuario, contraseña, nombre de la base de datos, etc).

## Ejecución
1. Instala las dependencias:
   ```
   ./mvnw clean install
   ```
2. Ejecuta la aplicación:
   ```
   ./mvnw spring-boot:run
   ```

La aplicación estará disponible en `http://localhost:8080`.

## Estructura del proyecto
- `controllers/`: Controladores REST
- `models/`: Entidades JPA
- `repositories/`: Repositorios Spring Data
- `services/`: Lógica de negocio
- `templates/`: Vistas HTML (Thymeleaf)

## Autor
- Daniel Cuatin

