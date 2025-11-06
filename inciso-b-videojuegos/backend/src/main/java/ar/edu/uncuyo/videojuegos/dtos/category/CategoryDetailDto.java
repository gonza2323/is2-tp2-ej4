package ar.edu.uncuyo.videojuegos.dtos.category;

import ar.edu.uncuyo.videojuegos.dtos.IdentifiableDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetailDto extends IdentifiableDto<Long> {
    private String name;
}
