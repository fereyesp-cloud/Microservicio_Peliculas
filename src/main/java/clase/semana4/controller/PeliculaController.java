package clase.semana4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clase.semana4.model.Pelicula;
import clase.semana4.service.PeliculasService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador REST que expone los endpoints del microservicio de películas.
 */
@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculasService peliculasService;

    // GET /peliculas
    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculasService.getAllPeliculas();
    }

    // GET /peliculas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getPeliculaById(@PathVariable long id) {
        Optional<Pelicula> pelicula = peliculasService.getPeliculaById(id);

        if (pelicula.isPresent()) {
            return ResponseEntity.ok(pelicula.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró una película con el id: " + id);
        }
    }

    // POST /peliculas
    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nueva = peliculasService.createPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // PUT /peliculas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePelicula(
            @PathVariable long id,
            @RequestParam String titulo,
            @RequestParam String anio,
            @RequestParam String director,
            @RequestParam String genero,
            @RequestParam String sinopsis) {

        Pelicula actualizada = peliculasService.updatePelicula(id, titulo, anio, director, genero, sinopsis);

        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró una película con el id: " + id);
        }
    }

    // DELETE /peliculas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePelicula(@PathVariable long id) {
        peliculasService.deletePelicula(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}