package ar.edu.uncuyo.videojuegos.controller;

import ar.edu.uncuyo.videojuegos.dtos.studio.StudioCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioSummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioUpdateDto;
import ar.edu.uncuyo.videojuegos.service.StudioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/studios")
public class StudioController extends BaseController<
        Long,
        StudioDetailDto,
        StudioSummaryDto,
        StudioCreateDto,
        StudioUpdateDto,
        StudioService> {

    public StudioController(StudioService service) {
        super(service);
    }
}
