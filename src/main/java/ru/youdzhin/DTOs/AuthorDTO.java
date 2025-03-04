package ru.youdzhin.DTOs;


import ru.youdzhin.objects.Book;

import java.util.List;

public record AuthorDTO (
        String biography,
        List<Book> books
) {
}
