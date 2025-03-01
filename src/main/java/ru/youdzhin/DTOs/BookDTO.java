package ru.youdzhin.DTOs;


import ru.youdzhin.objects.Author;
import ru.youdzhin.objects.Genre;

import java.util.List;


public record BookDTO (
        List<Author> author,
        Genre genre,
        short yearOfPublication,
        String description,
        Boolean status,
        byte rating
) {
}
