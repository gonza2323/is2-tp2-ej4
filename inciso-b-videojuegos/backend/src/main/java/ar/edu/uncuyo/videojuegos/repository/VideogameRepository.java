package ar.edu.uncuyo.videojuegos.repository;

import ar.edu.uncuyo.videojuegos.entity.Videogame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideogameRepository extends BaseRepository<Videogame, Long> {
    Page<Videogame> findAllByActiveTrue(Pageable pageable);

    Optional<Videogame> findByIdAndActiveTrue(Long id);

    boolean existsByTitleAndActiveTrue(String name);

    boolean existsByTitleAndActiveTrueAndIdNot(String title, Long id);
}