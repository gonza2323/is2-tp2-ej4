package org.example.apirest.services.strategy;

import org.example.apirest.entities.Libro;

import java.util.List;

public class ContextSearch {
    private StrategySearch estrategia;

    public void setEstrategia(StrategySearch estrategia) {
        this.estrategia = estrategia;
    }

    public List<Libro> ejecutarBusqueda(List<Libro> libros, String criterio) {
        return estrategia.buscar(libros, criterio);
    }
}
