package ar.edu.uncuyo.videojuegos.dtos.category;

import ar.edu.uncuyo.videojuegos.dtos.IdentifiableDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateDto extends IdentifiableDto<Long> {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "Máximo 50 caracteres")
    private String name;
}
