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

# Ejemplo de respuesta

json{
  "id": 1,
  "titulo": "El Señor de los Anillos: La Comunidad del Anillo",
  "año": 2001,
  "director": "Peter Jackson",
  "genero": "Fantasía / Aventura",
  "sinopsis": "Un hobbit llamado Frodo hereda un anillo mágico..."
}

# Películas disponibles
ID      / TITULO
1          El Señor de los Anillos: La Comunidad del Anillo
2          Interestelar
3          El Padrino
4          Parásito
5          Coco
6          El Club de la Pelea


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