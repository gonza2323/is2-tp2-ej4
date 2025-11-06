package org.example.apirest.controllers;

import org.example.apirest.entities.Libro;
import org.example.apirest.services.LibroServiceImpl;
import org.example.apirest.services.strategy.AuthorSearch;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/libros")
public class LibroController extends BaseControllerImpl<Libro, LibroServiceImpl> {

    private final LibroServiceImpl libroService;

    public LibroController(LibroServiceImpl libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/buscar")
    public List<Libro> buscar(
            @RequestParam String tipo,
            @RequestParam String criterio) {
        return libroService.buscar(tipo, criterio);
    }

}

