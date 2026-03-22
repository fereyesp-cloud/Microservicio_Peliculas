package peliculas.visualizarpeliculas.model;

/**
 * Clase que representa una Película en el sistema.
 * Contiene los atributos básicos de información de una película.
 */
public class Pelicula {

    /** Identificador único de la película */
    private int id;

    /** Título de la película */
    private String titulo;

    /** Año de estreno de la película */
    private int año;

    /** Nombre del director de la película */
    private String director;

    /** Género cinematográfico de la película */
    private String genero;

    /** Breve descripción del argumento de la película */
    private String sinopsis;

    /**
     * Constructor vacío requerido para la serialización JSON.
     */
    public Pelicula() {}

    /**
     * Constructor completo para crear una película con todos sus atributos.
     *
     * @param id       Identificador único de la película
     * @param titulo   Título de la película
     * @param año      Año de estreno
     * @param director Nombre del director
     * @param genero   Género cinematográfico
     * @param sinopsis Breve descripción del argumento
     */
    public Pelicula(int id, String titulo, int año, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    /**
     * Obtiene el identificador único de la película.
     * @return id de la película
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la película.
     * @param id identificador a asignar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el título de la película.
     * @return título de la película
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la película.
     * @param titulo título a asignar
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el año de estreno de la película.
     * @return año de estreno
     */
    public int getAño() {
        return año;
    }

    /**
     * Establece el año de estreno de la película.
     * @param año año a asignar
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Obtiene el nombre del director de la película.
     * @return nombre del director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Establece el nombre del director de la película.
     * @param director nombre del director a asignar
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Obtiene el género cinematográfico de la película.
     * @return género de la película
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género cinematográfico de la película.
     * @param genero género a asignar
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la sinopsis de la película.
     * @return sinopsis de la película
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * Establece la sinopsis de la película.
     * @param sinopsis sinopsis a asignar
     */
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}