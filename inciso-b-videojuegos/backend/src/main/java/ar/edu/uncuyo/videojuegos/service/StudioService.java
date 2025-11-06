package ar.edu.uncuyo.videojuegos.service;


import ar.edu.uncuyo.videojuegos.dtos.studio.StudioCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioSummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioUpdateDto;
import ar.edu.uncuyo.videojuegos.entity.Studio;
import ar.edu.uncuyo.videojuegos.entity.Studio;
import ar.edu.uncuyo.videojuegos.error.BusinessException;
import ar.edu.uncuyo.videojuegos.mapper.StudioMapper;
import ar.edu.uncuyo.videojuegos.repository.StudioRepository;
import ar.edu.uncuyo.videojuegos.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudioService extends BaseService<
        Studio,
        Long,
        StudioRepository,
        StudioDetailDto,
        StudioSummaryDto,
        StudioCreateDto,
        StudioUpdateDto,
        StudioMapper> {

    public StudioService(StudioRepository repository, StudioMapper mapper) {
        super("Estudio", repository, mapper);
    }

    @Override
    public void validateCreate(StudioCreateDto dto) {
        if (repository.existsByNameAndActiveTrue(dto.getName())) {
            throw new BusinessException("Ya existe una categoría con ese nombre");
        }
    }

    @Override
    public void validateUpdate(StudioUpdateDto dto) {
        if (repository.existsByNameAndActiveTrueAndIdNot(dto.getName(), dto.getId())) {
            throw new BusinessException("Ya existe una categoría con ese nombre");
        }
    }
}