package ar.edu.uncuyo.videojuegos.mapper;

import ar.edu.uncuyo.videojuegos.dtos.category.CategoryCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategoryDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategorySummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategoryUpdateDto;
import ar.edu.uncuyo.videojuegos.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDetailDto, CategorySummaryDto, CategoryCreateDto, CategoryUpdateDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "videogames", ignore = true)
    Category toEntity(CategoryCreateDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "videogames", ignore = true)
    void updateEntity(CategoryUpdateDto dto, @MappingTarget Category entity);

    @Override
    CategoryDetailDto toDto(Category entity);

    @Override
    CategorySummaryDto toSummaryDto(Category entity);
}
