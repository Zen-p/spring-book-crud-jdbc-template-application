package ru.youdzhin.objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    private Long id;

    private String biography;

    @JsonIgnoreProperties("authors")
    private List<Book> books;
}
