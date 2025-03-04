package ru.youdzhin.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.youdzhin.DTOs.AuthorDTO;
import ru.youdzhin.DTOs.BookDTO;
import ru.youdzhin.objects.Author;

import ru.youdzhin.services.AuthorService;

import java.util.List;


@RequestMapping("/api/authors")
@RestController
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllBooks () {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getBookById (@PathVariable("id") Long id) {
        return authorService.getById(id);
    }

    @PostMapping
    public void addANewAuthor (@RequestBody AuthorDTO author) {
        authorService.saveAuthor(author);
    }

    @PatchMapping("/{id}")
    public void changeBook (@PathVariable("id") long id, @RequestBody AuthorDTO author) {
        authorService.changeAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor (@PathVariable("id") long id) {
        authorService.deleteAuthor(id);
    }


}
