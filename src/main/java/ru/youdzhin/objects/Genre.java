package ru.youdzhin.objects;


import jakarta.persistence.*;

import java.util.List;

@Entity
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
            fetch = FetchType.EAGER,
            mappedBy = "genre"
    )
    private List<Book> books_by_genre;

}
