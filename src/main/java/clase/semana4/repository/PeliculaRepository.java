package clase.semana4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clase.semana4.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    
}