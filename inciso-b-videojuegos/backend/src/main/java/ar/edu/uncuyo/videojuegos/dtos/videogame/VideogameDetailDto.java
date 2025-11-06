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
public class VideogameDetailDto extends IdentifiableDto<Long> {
    private String title;
    private float price;
    private short amount;
    private String description;
    private boolean onSale;
    private LocalDate releaseDate;
    private Long studioId;
    private String studioName;
    private Long categoryId;
    private String categoryName;
}
