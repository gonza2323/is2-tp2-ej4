package ar.edu.uncuyo.videojuegos.repository;

import ar.edu.uncuyo.videojuegos.entity.Category;
import ar.edu.uncuyo.videojuegos.entity.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudioRepository extends BaseRepository<Studio, Long> {
    Page<Studio> findAllByActiveTrue(Pageable pageable);

    Optional<Studio> findByIdAndActiveTrue(Long id);

    boolean existsByNameAndActiveTrue(String name);
    boolean existsByNameAndActiveTrueAndIdNot(String name, Long id);
}
