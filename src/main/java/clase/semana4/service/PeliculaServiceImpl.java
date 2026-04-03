package clase.semana4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clase.semana4.model.Pelicula;
import clase.semana4.repository.PeliculaRepository;

import java.util.List;
import java.util.Optional;
/**
 * Servicio que gestiona la lógica de negocio relacionada con las películas.
 * 
 */
@Service
public class PeliculaServiceImpl implements PeliculasService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getAllPeliculas() {
         return peliculaRepository.findAll(); 
    }

    @Override
    public Optional<Pelicula> getPeliculaById(long id) {
         return peliculaRepository.findById(id); 
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) { 
        return peliculaRepository.save(pelicula); 
    }

    @Override
    public Pelicula updatePelicula(long id, String titulo, String anio, String director, String genero, String sinopsis) { return null; }

    @Override
    public void deletePelicula(long id) {}
}
