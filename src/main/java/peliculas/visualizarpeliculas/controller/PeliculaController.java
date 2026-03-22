package peliculas.visualizarpeliculas.controller;

import peliculas.visualizarpeliculas.model.Pelicula;
import peliculas.visualizarpeliculas.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que expone los endpoints del microservicio de películas.
 * Maneja las solicitudes HTTP y delega la lógica al servicio correspondiente.
 */
@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    /** Servicio que contiene la lógica de negocio de las películas */
    private final PeliculaService peliculaService;

    /**
     * Constructor que inyecta el servicio de películas mediante inyección de dependencias.
     *
     * @param peliculaService servicio de películas a inyectar
     */
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    /**
     * Endpoint que retorna la lista completa de películas disponibles.
     * Método HTTP: GET
     * Ruta: /peliculas
     *
     * @return ResponseEntity con la lista de películas y código HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Pelicula>> obtenerTodas() {
        List<Pelicula> peliculas = peliculaService.obtenerTodas();
        return ResponseEntity.ok(peliculas);
    }

    /**
     * Endpoint que retorna la información detallada de una película según su ID.
     * Método HTTP: GET
     * Ruta: /peliculas/{id}
     *
     * @param id identificador único de la película a buscar
     * @return ResponseEntity con la película y código HTTP 200 OK si fue encontrada,
     *         o código HTTP 404 NOT FOUND con mensaje de error si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        Optional<Pelicula> pelicula = peliculaService.obtenerPorId(id);

        if (pelicula.isPresent()) {
            // Película encontrada, se retorna con código 200 OK
            return ResponseEntity.ok(pelicula.get());
        } else {
            // Película no encontrada, se retorna con código 404 NOT FOUND
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ninguna película con el ID: " + id);
        }
    }
}