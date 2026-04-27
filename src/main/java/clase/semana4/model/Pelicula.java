package clase.semana4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

/**
 * Clase que representa una Película en el sistema.
 */
@Data
@Entity
@Table(name = "peliculas")
public class Pelicula extends RepresentationModel<Pelicula> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anio")
    private String anio;

    @Column(name = "director")
    private String director;

    @Column(name = "genero")
    private String genero;

    @Column(name = "sinopsis")
    private String sinopsis;
}