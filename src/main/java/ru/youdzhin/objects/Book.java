package ru.youdzhin.objects;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence_generator"
    )
    @SequenceGenerator(
            name = "book_sequence_generator",
            sequenceName = "book_sequence"
    )
    private Long id;

    @ManyToMany (
            cascade = CascadeType.ALL
    )
    @JoinTable (
            name = "book_author",
            joinColumns = @JoinColumn (name = "book_id"),
            inverseJoinColumns = @JoinColumn (name = "author_id")
    )
    private List<Author> author;

    @ManyToOne (
            optional = false,
            cascade = CascadeType.ALL
    )
    @JoinColumn (name = "genre_id")
    private Genre genre;

    private short yearOfPublication;

    private String description;

    private Boolean status;

    private byte rating;
}
