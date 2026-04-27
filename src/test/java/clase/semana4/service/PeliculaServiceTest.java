package clase.semana4.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import clase.semana4.dto.PeliculaDTO;
import clase.semana4.model.Pelicula;
import clase.semana4.repository.PeliculaRepository;

/**
 * Pruebas unitarias para PeliculaServiceImpl.
 * Usa Mockito para simular el repositorio sin tocar la base de datos.
 */
@ExtendWith(MockitoExtension.class)
public class PeliculaServiceTest {

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    private Pelicula pelicula;
    private PeliculaDTO peliculaDTO;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        pelicula = new Pelicula();
        pelicula.setId(1L);
        pelicula.setTitulo("Sueño de fuga");
        pelicula.setAnio("1994");
        pelicula.setDirector("Frank Darabont");
        pelicula.setGenero("Drama");
        pelicula.setSinopsis("El banquero Andy Dufresne es condenado a cadena perpetua.");

        peliculaDTO = new PeliculaDTO();
        peliculaDTO.setTitulo("Sueño de fuga");
        peliculaDTO.setAnio("1994");
        peliculaDTO.setDirector("Frank Darabont");
        peliculaDTO.setGenero("Drama");
        peliculaDTO.setSinopsis("El banquero Andy Dufresne es condenado a cadena perpetua.");
    }

    /**
     * Limpieza después de cada prueba.
     */
    @AfterEach
    void tearDown() {
        pelicula = null;
        peliculaDTO = null;
    }

    /**
     * Prueba 1: verifica que getAllPeliculas retorna la lista correctamente.
     */
    @Test
    void testGetAllPeliculas() {
        when(peliculaRepository.findAll()).thenReturn(Arrays.asList(pelicula));

        List<Pelicula> resultado = peliculaService.getAllPeliculas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Sueño de fuga", resultado.get(0).getTitulo());
        verify(peliculaRepository, times(1)).findAll();
    }

    /**
     * Prueba 2: verifica que createPelicula guarda y retorna la película correctamente.
     */
    @Test
    void testCreatePelicula() {
        when(peliculaRepository.save(any(Pelicula.class))).thenReturn(pelicula);

        Pelicula resultado = peliculaService.createPelicula(peliculaDTO);

        assertNotNull(resultado);
        assertEquals("Sueño de fuga", resultado.getTitulo());
        assertEquals("Frank Darabont", resultado.getDirector());
        verify(peliculaRepository, times(1)).save(any(Pelicula.class));
    }
}