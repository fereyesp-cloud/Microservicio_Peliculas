package clase.semana4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la entidad Pelicula.
 */
public class PeliculaTest {

    private Pelicula pelicula;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        pelicula = new Pelicula();
        pelicula.setTitulo("Sueño de fuga");
        pelicula.setAnio("1994");
        pelicula.setGenero("Drama");
        pelicula.setDirector("Frank Darabont");
        pelicula.setSinopsis("El banquero Andy Dufresne es arrestado por matar a su esposa y amante.");
    }

    /**
     * Limpieza después de cada prueba.
     */
    @AfterEach
    void tearDown() {
        pelicula = null;
    }

    /**
     * Prueba 1: verifica que los getters retornan los valores correctos.
     */
    @Test
    void testGettersAndSetters() {
        assertEquals("Sueño de fuga", pelicula.getTitulo());
        assertEquals("1994", pelicula.getAnio());
        assertEquals("Drama", pelicula.getGenero());
        assertEquals("Frank Darabont", pelicula.getDirector());
        assertNotNull(pelicula.getSinopsis());
    }

    /**
     * Prueba 2: verifica que el objeto Pelicula no es nulo tras su creación.
     */
    @Test
    void testPeliculaNoEsNula() {
        assertNotNull(pelicula);
        assertNotNull(pelicula.getTitulo());
        assertNotNull(pelicula.getDirector());
    }
}