package ru.youdzhin.objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_sequence_generator"
    )
    @SequenceGenerator(
            name = "genre_sequence_generator",
            sequenceName = "genre_sequence"
    )
    private Long id;

    private String name;

    @OneToMany (
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "genre"
    )
    @JsonIgnoreProperties("genre")
    private List<Book> books_by_genre;

}
