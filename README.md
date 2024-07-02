# FORUM ENGINE V 0.1 

***FORUM ENGINE*** es una `API REST` de código abierto escrito en Java para crear y gestionar foros. Este producto es un proyecto educativo del programa <a src="https://www.oracle.com/ar/education/oracle-next-education/">ONE (Oracle Next Education)</a> y <a src="https://www.aluracursos.com/">Alura LATAM</a> de la formación Back End; mi intención fue diseñarla para ser flexible y fácilmente integrable en cualquier aplicación basada en foros.

## Tabla de contenidos

-[Características](#características)
-[Tecnologías utilizadas](#tecnologías-utilizadas)
-[Primeros pasos](#primeros-pasos)
-[Documentación de la API](#documentación-de-la-api)
-[Contribuciones](#contribuciones)
-[Licencia](licencia)

## Características
- Registro y autenticación de usuarios
- Operaciones CRUD para temas y publicaciones del foro
- Control de acceso basado en roles
- Validación de datos y manejo de errores
- Migración de bases de datos con Flyway

## Tecnologías utilizadas

- Java (Open JDK 17)
- **Spring Boot**
- Dev Tools
- Lombok
- Spring Web
- Spring Data JPA
- Spring Security
- **Flyway Migration**
- **MySQL Driver**
- **Validation**
- **Maven** para gestión de dependencias

## Primeros pasos
### Requisitos
- Java 17 o superior
- Maven
- MySQL

### Instalación
**Clona el repositorio en tu dispositivo**
```
git clone https://github.com/MarianoMaldonado-dev/ForumEgineAPI.git
cd ForumEngineAPI
```
Abre con tu entorno de desarrollo de preferencia, necesitarás configurarlo con Spring Boot.
***Configura la base de datos***
La base de datos está configurada para adaptarse a las variables de entorno personalizadas de cada entorno de desarrollo pero si aún así prefieres configurarla o no sabes utilizar la variable de entorno, sigue éstos simples pasos.
Actualiza el archivo `src/main/resources/aplication.properties` con tu configuración personal de base de datos:
```
spring.datasource.url=jdbc:mysql://localhost:tuNumeroDePuertoDePreferencia/forumengineapi
spring.datasource.username= ***Coloca tu nombre de usuario personalizado***
spring.datasource.password= ***Coloca tu contraseña personalizada***
spring.jpa.hibernate.ddl.auto=update
flyway.enabled=true
```

***Si no utilizas un entorno de desarrollo, usa la terminal en el directorio donde está el proyecto y escribe:***
```
mvn clean install
mvn spring-boot:run
```
Una vez que se encuentre en ejecución deberías poder acceder a la aplicación a través del navegador por medio de localhost

# Documentación de la API

### Registro y Autenticación de Usuarios
***End Points***
- POST /api/auth/register: Registra un nuevo usuario
- POST /api/auth/login: Inicia la sesión y autentica un usuario devolviendo un token de JWT

### Temas del Foro

***End Points***
- GET /api/topics: Obtiene todos los temas del foro
- POST /api/topics: Crea un nuevo tema del foro
- GET /api/topics/{id}: Obtiene un tema específico del foro mediante el id
- PUT /api/topics/{id}: Actualiza un tema del foro por id
- DELETE /api/topics/{id}: Elimina un tema del foro mediante el id

### Publicaciones del Foro

***End Points***
- GET /api/topics/category: Obtienes todas las publicaciones de una categoría específica
- POST /api/topics/category/post: Crea una nueva publicación en un tema específico
- GET /api/topic/{id}: Busca una publicación por el id
- PUT /api/topic/{id]: Actualiza una publicación por el id
- DELETE /api/topic/{id}: Elimina una publicación por id

# Contribuciones

Por el momento no estoy aceptando contribuciones ni modificaciones en el repositorio ya que debo mencionar, está en su estado ***Alpha*** y no se encuentra funcionando. Tengo muchos errores aún por corregir que no logro comprender cómo hacerlo ya que el conocimiento adquirido no me fue suficiente para lograrlo. La base de datos en mi computadora no se conecta, me rehúsa la conexión y el tiempo que debo invertir para solucionar todo y dejar al menos una ***Beta*** Funcional, supera el tiempo permitido para presentar el proyecto. En pocas palabras, ***NO TENGO MAS TIEMPO PARA SOLUCIONARLO Y DEBO PRESENTARLO O ME QUEDARE AFUERA DEL PROGRAMA ONE Y TODO MI TIEMPO INVERTIDO ESTOS 6 MESES HABRA SIDO EN VANO.***
Sin embargo, no es mi intención abandonarlo y dejarlo así como está; tuve el mismo problema con mi otro proyecto ***Book Finder***
falta de tiempo, presiones por las fechas de entrega y una base de datos que no quiere conectarse. Mi idea a largo plazo es solucionar estos problemas y dejarlos funcionando como se debe; por ahora no tengo el conocimiento para lograrlo, pero teniendo más tiempo luego del programa y ya sin ninguna presión sé que lo podré lograr. Es por ésto que no estoy aceptando contribuciones, por qué debería aceptarlas si lo que quiero es aprender por mí mismo a resolverlas. No es egoísmo, sino ganas de aprender por mi cuenta como resolverlo.

# Licencia

### Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

<a src="https://github.com/MarianoMaldonado-dev/ForumEgineAPI.git">Forum Engine API<a>

#### { Dev</>Code } Informatic Solutions
