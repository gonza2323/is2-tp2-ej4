package ar.edu.uncuyo.videojuegos.service;


import ar.edu.uncuyo.videojuegos.dtos.category.CategoryCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategoryDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategorySummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategoryUpdateDto;
import ar.edu.uncuyo.videojuegos.error.BusinessException;
import ar.edu.uncuyo.videojuegos.mapper.CategoryMapper;
import ar.edu.uncuyo.videojuegos.repository.CategoryRepository;
import ar.edu.uncuyo.videojuegos.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<
        Category,
        Long,
        CategoryRepository,
        CategoryDetailDto,
        CategorySummaryDto,
        CategoryCreateDto,
        CategoryUpdateDto,
        CategoryMapper> {

    public CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        super("Categoría", repository, mapper);
    }

    @Override
    public void validateCreate(CategoryCreateDto dto) {
        if (repository.existsByNameAndActiveTrue(dto.getName())) {
            throw new BusinessException("Ya existe una categoría con ese nombre");
        }
    }

    @Override
    public void validateUpdate(CategoryUpdateDto dto) {
        if (repository.existsByNameAndActiveTrueAndIdNot(dto.getName(), dto.getId())) {
            throw new BusinessException("Ya existe una categoría con ese nombre");
        }
    }
}