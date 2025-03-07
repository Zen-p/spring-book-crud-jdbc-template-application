package ru.youdzhin.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;

    @JsonIgnoreProperties("books")
    private List<Author> authors;

    @JsonIgnoreProperties("books_by_genre")
    private Genre genre;

    private short yearOfPublication;

    private String description;

    private Boolean status;

    private byte rating;
}
