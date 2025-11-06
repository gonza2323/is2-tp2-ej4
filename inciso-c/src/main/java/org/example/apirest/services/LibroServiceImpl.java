package org.example.apirest.services;

import org.example.apirest.entities.Libro;
import org.example.apirest.repositories.LibroRepository;
import org.example.apirest.services.strategy.AuthorSearch;
import org.example.apirest.services.strategy.ContextSearch;
import org.example.apirest.services.strategy.GenreSearch;
import org.example.apirest.services.strategy.TitleSearch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        super(libroRepository);
        this.libroRepository = libroRepository;
    }

    @Override
    protected void applyUpdates(Libro current, Libro incoming) throws Exception {
        current.setTitulo(incoming.getTitulo());
        current.setFecha(incoming.getFecha());
        current.setGenero(incoming.getGenero());
        current.setPaginas(incoming.getPaginas());
        current.setAutores(incoming.getAutores());
    }

    public List<Libro> buscar(String tipo, String criterio) {
        List<Libro> todos = libroRepository.findAll();
        ContextSearch ctx = new ContextSearch();

        switch (tipo) {
            case "titulo" -> ctx.setEstrategia(new TitleSearch());
            case "genero" -> ctx.setEstrategia(new GenreSearch());
            case "autor" -> ctx.setEstrategia(new AuthorSearch());
            default -> throw new IllegalArgumentException("Tipo de búsqueda inválido");
        }

        return ctx.ejecutarBusqueda(todos, criterio);
    }
}

