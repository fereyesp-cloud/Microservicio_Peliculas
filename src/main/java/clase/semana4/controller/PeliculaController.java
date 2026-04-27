package clase.semana4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.RepresentationModel;

import clase.semana4.dto.PeliculaDTO;
import clase.semana4.model.Pelicula;
import clase.semana4.service.PeliculasService;

import jakarta.validation.Valid;

/**
 * Controlador REST que expone los endpoints del microservicio de películas.
 * Implementa HATEOAS para incluir vínculos de navegación en las respuestas.
 */
@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculasService peliculasService;

    /**
     * Obtiene todas las películas registradas.
     * @return lista de películas con vínculo a sí mismas
     */
    @GetMapping
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        List<Pelicula> peliculas = peliculasService.getAllPeliculas();
        for (Pelicula p : peliculas) {
            p.add(linkTo(methodOn(PeliculaController.class).getPeliculaById(p.getId())).withSelfRel());
        }
        return ResponseEntity.ok(peliculas);
    }

    /**
     * Obtiene una película por su ID.
     * @param id identificador de la película
     * @return la película encontrada con vínculos HATEOAS
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPeliculaById(@PathVariable long id) {
        Optional<Pelicula> pelicula = peliculasService.getPeliculaById(id);

        if (pelicula.isPresent()) {
            Pelicula p = pelicula.get();
            p.add(linkTo(methodOn(PeliculaController.class).getPeliculaById(id)).withSelfRel());
            p.add(linkTo(methodOn(PeliculaController.class).getAllPeliculas()).withRel("todas-las-peliculas"));
            p.add(linkTo(methodOn(PeliculaController.class).deletePelicula(id)).withRel("eliminar"));
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró una película con el id: " + id);
        }
    }

    /**
     * Crea una nueva película.
     * @param peliculaDTO datos validados de la nueva película
     * @return la película creada con vínculos HATEOAS
     */
    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@Valid @RequestBody PeliculaDTO peliculaDTO) {
        Pelicula nueva = peliculasService.createPelicula(peliculaDTO);
        nueva.add(linkTo(methodOn(PeliculaController.class).getPeliculaById(nueva.getId())).withSelfRel());
        nueva.add(linkTo(methodOn(PeliculaController.class).getAllPeliculas()).withRel("todas-las-peliculas"));
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    /**
     * Actualiza una película existente.
     * @param id identificador de la película a actualizar
     * @param peliculaDTO nuevos datos validados
     * @return la película actualizada con vínculos HATEOAS
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePelicula(
            @PathVariable long id,
            @Valid @RequestBody PeliculaDTO peliculaDTO) {

        Pelicula actualizada = peliculasService.updatePelicula(id, peliculaDTO);

        if (actualizada != null) {
            actualizada.add(linkTo(methodOn(PeliculaController.class).getPeliculaById(id)).withSelfRel());
            actualizada.add(linkTo(methodOn(PeliculaController.class).getAllPeliculas()).withRel("todas-las-peliculas"));
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró una película con el id: " + id);
        }
    }

    /**
     * Elimina una película por su ID.
     * @param id identificador de la película a eliminar
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePelicula(@PathVariable long id) {
        peliculasService.deletePelicula(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}