package org.example.apirest.services.strategy;

import org.example.apirest.entities.Libro;

import java.util.List;

public interface StrategySearch {
    List<Libro> buscar(List<Libro> libros, String criterio);

}
