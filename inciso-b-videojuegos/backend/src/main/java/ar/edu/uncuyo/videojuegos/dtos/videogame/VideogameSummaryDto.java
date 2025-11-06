package ar.edu.uncuyo.videojuegos.dtos.videogame;

import ar.edu.uncuyo.videojuegos.dtos.IdentifiableDto;
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
public class VideogameSummaryDto extends IdentifiableDto<Long> {
    private String title;
    private float price;
    private short amount;
    private Long studioId;
    private String studioName;
    private Long categoryId;
    private String categoryName;
}
