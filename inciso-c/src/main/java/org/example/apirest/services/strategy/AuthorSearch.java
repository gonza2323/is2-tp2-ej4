package org.example.apirest.services.strategy;

import org.example.apirest.entities.Libro;

import java.util.List;

public class AuthorSearch implements StrategySearch {
    @Override
    public List<Libro> buscar(List<Libro> libros, String criterio) {
        return libros.stream()
                .filter(libro ->
                        libro.getAutores() != null && libro.getAutores().stream()
                                .anyMatch(a -> a.getNombre().toLowerCase().contains(criterio.toLowerCase()))
                )
                .toList();
    }
}
