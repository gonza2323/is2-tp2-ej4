package org.example.apirest.services.strategy;

import org.example.apirest.entities.Libro;

import java.util.List;

public class GenreSearch implements StrategySearch {
    @Override
    public List<Libro> buscar(List<Libro> libros, String criterio) {
        return libros.stream()
                .filter(l -> l.getGenero().toLowerCase().contains(criterio.toLowerCase()))
                .toList();
    }
}
