package ar.edu.uncuyo.videojuegos.repository;

import ar.edu.uncuyo.videojuegos.entity.Category;
import ar.edu.uncuyo.videojuegos.entity.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
    Page<Category> findAllByActiveTrue(Pageable pageable);

    Optional<Category> findByIdAndActiveTrue(Long id);

    boolean existsByNameAndActiveTrue(String name);
    boolean existsByNameAndActiveTrueAndIdNot(String name, Long id);
}
