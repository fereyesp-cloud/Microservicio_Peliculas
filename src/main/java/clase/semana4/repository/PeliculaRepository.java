package clase.semana4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import clase.semana4.model.Pelicula;

/**
 * Repositorio para el acceso a datos de la entidad Pelicula.
 * Extiende JpaRepository para obtener las operaciones CRUD básicas.
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    /**
     * Busca películas por su título.
     */
    List<Pelicula> findByTitulo(String titulo);
}