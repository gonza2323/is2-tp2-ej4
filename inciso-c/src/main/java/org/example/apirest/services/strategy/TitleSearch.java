package org.example.apirest.services.strategy;

import org.example.apirest.entities.Libro;

import java.util.List;

public class TitleSearch implements StrategySearch {
    @Override
    public List<Libro> buscar(List<Libro> libros, String criterio) {
        return libros.stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(criterio.toLowerCase()))
                .toList();
    }
}
