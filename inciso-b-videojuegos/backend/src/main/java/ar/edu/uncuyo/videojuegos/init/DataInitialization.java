package ar.edu.uncuyo.videojuegos.init;

import ar.edu.uncuyo.videojuegos.dtos.category.CategoryCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.studio.StudioCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.videogame.VideogameCreateDto;
import ar.edu.uncuyo.videojuegos.entity.Category;
import ar.edu.uncuyo.videojuegos.entity.Studio;
import ar.edu.uncuyo.videojuegos.repository.CategoryRepository;
import ar.edu.uncuyo.videojuegos.repository.StudioRepository;
import ar.edu.uncuyo.videojuegos.service.CategoryService;
import ar.edu.uncuyo.videojuegos.service.StudioService;
import ar.edu.uncuyo.videojuegos.service.VideogameService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataInitialization implements CommandLineRunner {

    private final VideogameService videogameService;
    private final Random random = new Random(42);

    private final int CANT_CATEGORIAS = 10;
    private final int CANT_ESTUDIOS = 20;
    private final int CANT_VIDEOJUEGOS = 50;
    private final CategoryService categoryService;
    private final StudioService studioService;
    private final CategoryRepository categoryRepository;
    private final StudioRepository studioRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        crearDatosIniciales();
    }

    @Transactional
    protected void crearDatosIniciales() throws Exception {
        if (!videogameService.findDtos(null).getContent().isEmpty()) {
            System.out.println("Datos iniciales ya creados. Salteando creación de datos iniciales. Para forzar su creación, borrar la base de datos");
            return;
        }

        System.out.println("Creando datos iniciales...");

        // Creación de datos iniciales
        crearCategorias();
        crearEstudios();
        crearVideojuegos();

        System.out.println("Datos iniciales creados.");
    }

    @Transactional
    protected void crearCategorias() {
        for (int i = 0; i < CANT_CATEGORIAS; i++) {
            categoryService.create(new CategoryCreateDto("CATEGORÍA " + String.format("%02d", i)));
        }
    }

    @Transactional
    protected void crearEstudios() {
        for (int i = 0; i < CANT_ESTUDIOS; i++) {
            studioService.create(new StudioCreateDto("ESTUDIO " + String.format("%02d", i)));
        }
    }

    @Transactional
    protected void crearVideojuegos() {
        List<Category> categories = categoryRepository.findAll();
        List<Studio> studios = studioRepository.findAll();

        for (int i = 1; i < CANT_VIDEOJUEGOS + 1; i++) {
            long randomCateogoryId = categories.get(random.nextInt(categories.size())).getId();
            long randomStudioId = studios.get(random.nextInt(studios.size())).getId();

            videogameService.create(VideogameCreateDto.builder()
                    .title("VIDEOJUEGO " + String.format("%02d", i))
                    .description("DESCRIPCIÓN " + String.format("%02d", i))
                    .price(random.nextFloat(1, 100))
                    .amount((short) random.nextInt(50))
                    .onSale(random.nextBoolean())
                    .releaseDate(LocalDate.ofYearDay(random.nextInt(1990, 2025), random.nextInt(1,365)))
                    .categoryId(randomCateogoryId)
                    .studioId(randomStudioId).build());
        }
    }
}
