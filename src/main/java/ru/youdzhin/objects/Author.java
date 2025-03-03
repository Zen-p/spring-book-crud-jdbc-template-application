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

    @ManyToMany (
//            cascade = CascadeType.ALL
            mappedBy = "authors"
    )
    @JsonIgnoreProperties("authors")
//    @JoinTable (
//            name = "book_author",
//            joinColumns = @JoinColumn (name = "author_id"),
//            inverseJoinColumns = @JoinColumn (name = "book_id")
//    )
    private List<Book> books;
}
