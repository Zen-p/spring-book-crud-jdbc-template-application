package ru.youdzhin.objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
            mappedBy = "authors"
    )
    @JsonIgnoreProperties("authors")
    private List<Book> books;
}
