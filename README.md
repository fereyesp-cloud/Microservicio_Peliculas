Microservicio de Películas 🎬
Microservicio desarrollado en Spring Boot que proporciona información sobre películas a través de una API REST.

# Tecnologías
Java 17
Spring Boot 3.2.0
Maven

# Endpoints disponibles

# Obtener todas las películas
GET http://localhost:8080/peliculas
# Obtener película por ID
GET http://localhost:8080/peliculas/{id}
# agregar pelicula
post http://localhost:8080/peliculas
# eliminar pelicula
DELETE http://localhost:8080/peliculas/{ID}
# actualizar pelicula
PUT PUT http://localhost:8080/peliculas/{ID}





Cómo ejecutar
# Clonar el repositorio
git clone <url-del-repositorio>

# Entrar al directorio
cd microservicio-peliculas

# Ejecutar con Maven
./mvnw spring-boot:run
El servicio estará disponible en: http://localhost:8080
# Manejo de errores
Si se consulta un ID que no existe, el servicio retorna un 404 Not Found con el mensaje:
No se encontró ninguna película con el ID: {id}