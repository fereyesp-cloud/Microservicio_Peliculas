package clase.semana4.service;

import clase.semana4.model.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculasService {

    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculaById(long id);
    Pelicula createPelicula(Pelicula pelicula);
    Pelicula updatePelicula(long id, String titulo, String anio, String director, String genero, String sinopsis);
    void deletePelicula(long id);

}