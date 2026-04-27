# 🎬 Microservicio de Películas

Microservicio desarrollado con **Spring Boot** que proporciona información básica sobre películas. Implementa una API REST con DTOs, validaciones, HATEOAS y pruebas unitarias.

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- Spring HATEOAS
- Oracle Database
- Lombok
- JUnit 5 + Mockito

---

## ▶️ Cómo ejecutar el proyecto

```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

---

## 📋 Endpoints disponibles

### 🔵 GET `/peliculas`
Obtiene la lista de todas las películas registradas.

- **Método:** `GET`
- **URL:** `http://localhost:8080/peliculas`
- **Respuesta exitosa:** `200 OK`

---

### 🔵 GET `/peliculas/{id}`
Obtiene una película específica por su ID.

- **Método:** `GET`
- **URL:** `http://localhost:8080/peliculas/{id}`
- **Parámetro:** `id` — identificador de la película
- **Respuesta exitosa:** `200 OK`
- **Respuesta si no existe:** `404 Not Found`


---

### 🟢 POST `/peliculas`
Crea una nueva película.

- **Método:** `POST`
- **URL:** `http://localhost:8080/peliculas`
- **Content-Type:** `application/json`
- **Respuesta exitosa:** `201 Created`

**Ejemplo de body:**
```json
{
  "titulo": "El Padrino",
  "anio": "1972",
  "director": "Francis Ford Coppola",
  "genero": "Crimen",
  "sinopsis": "La historia de la familia mafiosa Corleone y su lucha por el poder."
}
```

---

### 🟡 PUT `/peliculas/{id}`
Actualiza una película existente.

- **Método:** `PUT`
- **URL:** `http://localhost:8080/peliculas/{id}`
- **Parámetro:** `id` — identificador de la película
- **Content-Type:** `application/json`
- **Respuesta exitosa:** `200 OK`
- **Respuesta si no existe:** `404 Not Found`

**Ejemplo de body:**
```json
{
  "titulo": "El Padrino",
  "anio": "1972",
  "director": "Francis Ford Coppola",
  "genero": "Drama",
  "sinopsis": "Historia actualizada de la familia Corleone."
}
```
---

### 🔴 DELETE `/peliculas/{id}`
Elimina una película por su ID.

- **Método:** `DELETE`
- **URL:** `http://localhost:8080/peliculas/{id}`
- **Parámetro:** `id` — identificador de la película
- **Respuesta exitosa:** `204 No Content`

---
---

## 🧪 Pruebas unitarias

El proyecto incluye pruebas unitarias en tres capas:

| Clase                      | Descripción                                      |
|----------------------------|--------------------------------------------------|
| `PeliculaTest`             | Pruebas sobre la entidad Pelicula (getters/setters) |
| `PeliculaServiceTest`      | Pruebas del servicio con Mockito                 |
| `PeliculaControllerTest`   | Pruebas del controller con MockMvc               |

Para ejecutar las pruebas:

```bash
./mvnw test
```

