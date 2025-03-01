package ru.youdzhin.objects;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence_generator"
    )
    @SequenceGenerator(
            name = "author_sequence_generator",
            sequenceName = "author_sequence"
    )
    private Long id;

    private String biography;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (
            name = "book_author",
            joinColumns = @JoinColumn (name = "author_id"),
            inverseJoinColumns = @JoinColumn (name = "book_id")
    )
    private List<Book> books;
}
