package ar.edu.uncuyo.videojuegos.dtos.videogame;

import ar.edu.uncuyo.videojuegos.dtos.IdentifiableDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VideogameUpdateDto extends IdentifiableDto<Long> {
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
