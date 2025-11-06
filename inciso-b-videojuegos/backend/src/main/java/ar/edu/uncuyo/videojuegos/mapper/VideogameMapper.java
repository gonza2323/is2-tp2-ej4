package ar.edu.uncuyo.videojuegos.mapper;

import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameSummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameUpdateDto;
import ar.edu.uncuyo.videojuegos.entity.Videogame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VideogameMapper extends BaseMapper<Videogame, VideogameDetailDto, VideogameSummaryDto, VideogameCreateDto, VideogameUpdateDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "studio", ignore = true)
    Videogame toEntity(VideogameCreateDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "studio", ignore = true)
    void updateEntity(VideogameUpdateDto dto, @MappingTarget Videogame entity);

    @Override
    @Mapping(target = "studioId", source = "studio.id")
    @Mapping(target = "studioName", source = "studio.name")
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    VideogameDetailDto toDto(Videogame entity);

    @Override
    @Mapping(target = "studioId", source = "studio.id")
    @Mapping(target = "studioName", source = "studio.name")
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    VideogameSummaryDto toSummaryDto(Videogame entity);
}
