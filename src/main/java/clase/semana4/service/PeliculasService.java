package clase.semana4.service;

import clase.semana4.dto.PeliculaDTO;
import clase.semana4.model.Pelicula;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para la gestión de películas.
 * Define las operaciones CRUD disponibles para el recurso Pelicula.
 */
public interface PeliculasService {

    /**
     * Obtiene todas las películas registradas.
     * @return lista de películas
     */
    List<Pelicula> getAllPeliculas();

    /**
     * Obtiene una película por su ID.
     * @param id identificador de la película
     * @return la película encontrada o vacío si no existe
     */
    Optional<Pelicula> getPeliculaById(long id);

    /**
     * Crea una nueva película a partir de un DTO.
     * @param peliculaDTO datos de la película a crear
     * @return la película creada
     */
    Pelicula createPelicula(PeliculaDTO peliculaDTO);

    /**
     * Actualiza una película existente a partir de un DTO.
     * @param id identificador de la película a actualizar
     * @param peliculaDTO nuevos datos de la película
     * @return la película actualizada
     */
    Pelicula updatePelicula(long id, PeliculaDTO peliculaDTO);

    /**
     * Elimina una película por su ID.
     * @param id identificador de la película a eliminar
     */
    void deletePelicula(long id);
}