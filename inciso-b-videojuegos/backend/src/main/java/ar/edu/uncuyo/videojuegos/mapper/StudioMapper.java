package ar.edu.uncuyo.videojuegos.mapper;

import ar.edu.uncuyo.videojuegos.dtos.studio.StudioCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioSummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioUpdateDto;
import ar.edu.uncuyo.videojuegos.entity.Studio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudioMapper extends BaseMapper<Studio, StudioDetailDto, StudioSummaryDto, StudioCreateDto, StudioUpdateDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "videogames", ignore = true)
    Studio toEntity(StudioCreateDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "videogames", ignore = true)
    void updateEntity(StudioUpdateDto dto, @MappingTarget Studio entity);

    @Override
    StudioDetailDto toDto(Studio entity);

    @Override
    StudioSummaryDto toSummaryDto(Studio entity);
}
