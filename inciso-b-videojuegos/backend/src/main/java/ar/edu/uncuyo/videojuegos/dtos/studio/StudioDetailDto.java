package ar.edu.uncuyo.videojuegos.dtos.studio;

import ar.edu.uncuyo.videojuegos.dtos.IdentifiableDto;
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
public class StudioDetailDto extends IdentifiableDto<Long> {
    private String name;
}
