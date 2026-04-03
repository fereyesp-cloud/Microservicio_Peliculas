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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * Controlador REST que expone los endpoints del microservicio de películas.
 * Maneja las solicitudes HTTP y delega la lógica al servicio correspondiente.
 */
@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculasService peliculasService;

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

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculasService.getAllPeliculas();
    }

}