package ar.edu.uncuyo.videojuegos.service;

import ar.edu.uncuyo.videojuegos.dtos.studio.StudioCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioSummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioUpdateDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameSummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameUpdateDto;
import ar.edu.uncuyo.videojuegos.entity.Category;
import ar.edu.uncuyo.videojuegos.entity.Studio;
import ar.edu.uncuyo.videojuegos.entity.Videogame;
import ar.edu.uncuyo.videojuegos.error.BusinessException;
import ar.edu.uncuyo.videojuegos.mapper.StudioMapper;
import ar.edu.uncuyo.videojuegos.mapper.VideogameMapper;
import ar.edu.uncuyo.videojuegos.repository.StudioRepository;
import ar.edu.uncuyo.videojuegos.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideogameService extends BaseService<
        Videogame,
        Long,
        VideogameRepository,
        VideogameDetailDto,
        VideogameSummaryDto,
        VideogameCreateDto,
        VideogameUpdateDto,
        VideogameMapper> {

    private final StudioService studioService;
    private final CategoryService categoryService;

    public VideogameService(VideogameRepository repository,
                            VideogameMapper mapper,
                            StudioService studioService,
                            CategoryService categoryService) {
        super("Videojuego", repository, mapper);
        this.studioService = studioService;
        this.categoryService = categoryService;
    }

    @Override
    public void validateCreate(VideogameCreateDto dto) {
        if (repository.existsByTitleAndActiveTrue(dto.getTitle())) {
            throw new BusinessException("Ya existe un videojuego con ese nombre");
        }
    }

    @Override
    public void validateUpdate(VideogameUpdateDto dto) {
        if (repository.existsByTitleAndActiveTrueAndIdNot(dto.getTitle(), dto.getId())) {
            throw new BusinessException("Ya existe un videojuego con ese nombre");
        }
    }

    @Override
    public void preCreate(VideogameCreateDto dto, Videogame game) {
        Studio studio = studioService.find(dto.getStudioId());
        Category category = categoryService.find(dto.getCategoryId());
        game.setStudio(studio);
        game.setCategory(category);
    }

    @Override
    public void preUpdate(VideogameUpdateDto dto, Videogame game) {
        Studio studio = studioService.find(dto.getStudioId());
        Category category = categoryService.find(dto.getCategoryId());
        game.setStudio(studio);
        game.setCategory(category);
    }
}