package ar.edu.uncuyo.videojuegos.controller;

import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameSummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameUpdateDto;
import ar.edu.uncuyo.videojuegos.service.VideogameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/videogames")
public class VideogameController extends BaseController<
        Long,
        VideogameDetailDto,
        VideogameSummaryDto,
        VideogameCreateDto,
        VideogameUpdateDto,
        VideogameService> {

    public VideogameController(VideogameService service) {
        super(service);
    }
}
