package ar.edu.uncuyo.videojuegos.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Videogame extends BaseEntity<Long> {
    @Column(length = 100, nullable = false)
    private String title;

    @Column
    private float price;

    @Column
    private short amount;

    @Column(columnDefinition = "TEXT", nullable = false, length = 512)
    private String description;

    @Column
    private boolean onSale;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(nullable = false)
    private LocalDate releaseDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Studio studio;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
}