package clase.semana4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO para la transferencia de datos de una Película.
 * Contiene las validaciones de entrada para los campos recibidos del cliente.
 */
@Data
public class PeliculaDTO {

    @NotBlank(message = "El título de la película es obligatorio")
    @Size(max = 100, message = "El título no puede superar los 100 caracteres")
    private String titulo;

    @NotBlank(message = "El año de la película es obligatorio")
    @Size(max = 50, message = "El año no puede superar los 50 caracteres")
    private String anio;

    @NotBlank(message = "El nombre del director es obligatorio")
    @Size(max = 50, message = "El nombre del director no puede superar los 50 caracteres")
    private String director;

    @NotBlank(message = "El género es obligatorio")
    @Size(max = 15, message = "El género no puede superar los 15 caracteres")
    private String genero;

    @NotBlank(message = "La sinopsis es obligatoria")
    @Size(max = 100, message = "La sinopsis no puede superar los 100 caracteres")
    private String sinopsis;
}