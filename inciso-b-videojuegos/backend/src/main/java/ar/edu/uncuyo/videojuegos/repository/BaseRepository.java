package ar.edu.uncuyo.videojuegos.repository;

import ar.edu.uncuyo.videojuegos.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<E, ID> {
    Optional<E> findByIdAndActiveTrue(ID id);
    Page<E> findByActiveTrue(Pageable pageable);
}
