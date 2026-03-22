package peliculas.visualizarpeliculas.service;

import peliculas.visualizarpeliculas.model.Pelicula;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona la lógica de negocio relacionada con las películas.
 * Utiliza una lista en memoria como fuente de datos, sin necesidad de base de datos.
 */
@Service
public class PeliculaService {

    /**
     * Lista las peliculas
     * Contiene 6 películas predefinidas con sus atributos completos.
     */
    private final List<Pelicula> peliculas = Arrays.asList(
        new Pelicula(
            1,
            "El Señor de los Anillos: La Comunidad del Anillo",
            2001,
            "Peter Jackson",
            "Fantasía / Aventura",
            "Un hobbit llamado Frodo hereda un anillo mágico y debe destruirlo en las grietas del destino para evitar que el Señor Oscuro Sauron conquiste la Tierra Media."
        ),
        new Pelicula(
            2,
            "Interestelar",
            2014,
            "Christopher Nolan",
            "Ciencia Ficción / Drama",
            "Un grupo de astronautas viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad, mientras exploran los límites del espacio y el tiempo."
        ),
        new Pelicula(
            3,
            "El Padrino",
            1972,
            "Francis Ford Coppola",
            "Drama / Crimen",
            "La historia de la poderosa familia mafiosa Corleone y la transformación de Michael, el hijo menor, quien termina convirtiéndose en el nuevo jefe de la organización criminal."
        ),
        new Pelicula(
            4,
            "Parásito",
            2019,
            "Bong Joon-ho",
            "Drama / Thriller",
            "Una familia pobre se infiltra en la vida de una familia rica mediante engaños, desencadenando una serie de eventos que revelan las profundas desigualdades de la sociedad surcoreana."
        ),
        new Pelicula(
            5,
            "Coco",
            2017,
            "Lee Unkrich",
            "Animación / Familiar",
            "Miguel, un joven mexicano apasionado por la música, viaja al mundo de los muertos durante el Día de los Muertos y descubre los secretos ocultos de su familia."
        ),
        new Pelicula(
            6,
            "El Club de la Pelea",
            1999,
            "David Fincher",
            "Drama / Thriller",
            "Un oficinista insatisfecho con su vida forma un club de lucha clandestino junto a un carismático vendedor de jabón, pero las cosas se complican cuando el club evoluciona hacia algo más oscuro."
        )
    );

    /**
     * Obtiene la lista completa de películas registradas
     *
     * @return lista con todas las películas disponibles
     */
    public List<Pelicula> obtenerTodas() {
        return peliculas;
    }

    /**
     * Busca y retorna una película según su identificador único.
     * Utiliza Stream para filtrar en la lista
     *
     * @param id identificador de la película a buscar
     * @return Optional con la película si fue encontrada, o vacío si/no existe
     */
    public Optional<Pelicula> obtenerPorId(int id) {
        return peliculas.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}