package ar.edu.uncuyo.videojuegos.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Studio extends BaseEntity<Long> {
    @Column(length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "studio", cascade = CascadeType.PERSIST)
    private List<Videogame> videogames = new ArrayList<>();
}
