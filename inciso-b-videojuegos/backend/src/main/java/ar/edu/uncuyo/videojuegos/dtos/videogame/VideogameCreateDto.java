package ar.edu.uncuyo.videojuegos.dtos.videogame;

import ar.edu.uncuyo.videojuegos.entity.Category;
import ar.edu.uncuyo.videojuegos.entity.Studio;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideogameCreateDto {
    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 50, message = "Máximo 50 caracteres")
    private String title;

    @NotNull(message = "Debe indicar el precio")
    private float price;

    @NotNull(message = "Debe indicar la cantidad disponbile")
    private short amount;

    @NotBlank(message = "Debe dar una descripción")
    private String description;

    private boolean onSale;

    @NotNull(message = "Debe indicar una fecha de lanzamiento")
    private LocalDate releaseDate;

    @NotNull(message = "Debe seleccionar un estudio")
    private Long studioId;

    @NotNull(message = "Debe seleccionar una categoría")
    private Long categoryId;
}
