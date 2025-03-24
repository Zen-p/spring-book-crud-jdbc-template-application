package ru.youdzhin.objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    @Id
    private Long id;

    private String name;

    @JsonIgnoreProperties("genre")
    private List<Book> books_by_genre;

}