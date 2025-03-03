package ru.youdzhin.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.youdzhin.objects.Author;

import ru.youdzhin.services.AuthorService;


@RequestMapping("/api/authors")
@RestController
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

//    @GetMapping
//    public List<Book> getAllBooks () {
//        return authorService.getAllBooks();
//    }

    @GetMapping("/{id}")
    public Author getBookById (@PathVariable("id") Long id) {
        return authorService.getById(id);
    }
}
