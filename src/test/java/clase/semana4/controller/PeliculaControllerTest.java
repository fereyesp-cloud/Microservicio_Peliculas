package clase.semana4.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import clase.semana4.dto.PeliculaDTO;
import clase.semana4.model.Pelicula;
import clase.semana4.service.PeliculasService;

/**
 * Pruebas unitarias para PeliculaController.
 * Usa MockMvc para simular peticiones HTTP sin levantar el servidor completo.
 */
@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculasService peliculasService;

    @Autowired
    private ObjectMapper objectMapper;

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
     * Prueba 1: GET /peliculas retorna lista de películas con status 200.
     */
    @Test
    void testGetAllPeliculas() throws Exception {
        when(peliculasService.getAllPeliculas()).thenReturn(Arrays.asList(pelicula));

        mockMvc.perform(get("/peliculas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Sueño de fuga"))
                .andExpect(jsonPath("$[0].director").value("Frank Darabont"));

        verify(peliculasService, times(1)).getAllPeliculas();
    }

    /**
     * Prueba 2: POST /peliculas crea una película y retorna status 201.
     */
    @Test
    void testCreatePelicula() throws Exception {
        when(peliculasService.createPelicula(any(PeliculaDTO.class))).thenReturn(pelicula);

        mockMvc.perform(post("/peliculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(peliculaDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo").value("Sueño de fuga"))
                .andExpect(jsonPath("$.director").value("Frank Darabont"));

        verify(peliculasService, times(1)).createPelicula(any(PeliculaDTO.class));
    }
}