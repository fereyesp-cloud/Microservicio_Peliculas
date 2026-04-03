package clase.semana4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;
/**
 * Clase que representa una Película en el sistema.
 * Contiene los atributos básicos de información de una película.
 */
@Entity
@Table(name = "peliculas")
public class Pelicula {

    /**
     * indetificador de valores 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "No se puede ingresar un titulo vacio")
    @Column(name = "titulo")
    private String titulo;

    @NotBlank(message = "No se puede ingresar un año vacio")
    @Column(name = "año")
    private String anio;

    @NotBlank(message = "No se puede ingresar un director vacio")
    @Column(name = "director")
    private String director;
    
    @NotBlank(message = "No se puede ingresar un genero vacio")
    @Column(name = "genero")
    private String genero;

    
    @NotBlank(message = "No se puede ingresar un sinopsis vacio")
    @Column(name = "sinopsis")
    private String sinopsis;

    /**
     * setter
     * @return
     */
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAnio() {
        return anio;
    }

        /**
     * getters
     * @return
     */

    public void setAnio(String anio) {
        this.anio = anio;
    }


    public String getDirector() {
        return director;
    }


    public void setDirector(String director) {
        this.director = director;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getSinopsis() {
        return sinopsis;
    }


    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

}
