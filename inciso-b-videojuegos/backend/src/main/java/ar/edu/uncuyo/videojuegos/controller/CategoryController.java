package ar.edu.uncuyo.videojuegos.controller;

import ar.edu.uncuyo.videojuegos.dtos.IdentifiableDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategoryCreateDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategoryDetailDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategorySummaryDto;
import ar.edu.uncuyo.videojuegos.dtos.category.CategoryUpdateDto;
import ar.edu.uncuyo.videojuegos.service.BaseService;
import ar.edu.uncuyo.videojuegos.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController extends BaseController<
        Long,
        CategoryDetailDto,
        CategorySummaryDto,
        CategoryCreateDto,
        CategoryUpdateDto,
        CategoryService> {

    public CategoryController(CategoryService service) {
        super(service);
    }
}
