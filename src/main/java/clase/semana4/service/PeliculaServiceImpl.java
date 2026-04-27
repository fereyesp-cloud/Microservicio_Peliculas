package clase.semana4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clase.semana4.dto.PeliculaDTO;
import clase.semana4.model.Pelicula;
import clase.semana4.repository.PeliculaRepository;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementación del servicio que gestiona la lógica de negocio
 * relacionada con las películas.
 */
@Slf4j
@Service
public class PeliculaServiceImpl implements PeliculasService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getAllPeliculas() {
        log.info("Obteniendo todas las películas");
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> getPeliculaById(long id) {
        log.info("Buscando película con id: {}", id);
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula createPelicula(PeliculaDTO peliculaDTO) {
        log.info("Registrando nueva película: {}", peliculaDTO.getTitulo());
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setAnio(peliculaDTO.getAnio());
        pelicula.setDirector(peliculaDTO.getDirector());
        pelicula.setGenero(peliculaDTO.getGenero());
        pelicula.setSinopsis(peliculaDTO.getSinopsis());
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(long id, PeliculaDTO peliculaDTO) {
        if (peliculaRepository.existsById(id)) {
            log.info("Actualizando película con id: {}", id);
            Pelicula pelicula = new Pelicula();
            pelicula.setId(id);
            pelicula.setTitulo(peliculaDTO.getTitulo());
            pelicula.setAnio(peliculaDTO.getAnio());
            pelicula.setDirector(peliculaDTO.getDirector());
            pelicula.setGenero(peliculaDTO.getGenero());
            pelicula.setSinopsis(peliculaDTO.getSinopsis());
            return peliculaRepository.save(pelicula);
        } else {
            log.error("No se encontró la película con id: {}", id);
            return null;
        }
    }

    @Override
    public void deletePelicula(long id) {
        if (peliculaRepository.existsById(id)) {
            log.info("Eliminando película con id: {}", id);
            peliculaRepository.deleteById(id);
        } else {
            log.error("No se encontró la película con id: {} para eliminar", id);
        }
    }
}