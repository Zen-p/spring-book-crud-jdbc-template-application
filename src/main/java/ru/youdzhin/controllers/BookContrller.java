package ru.youdzhin.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.youdzhin.DTOs.BookDTO;
import ru.youdzhin.objects.Book;
import ru.youdzhin.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookContrller {

    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks () {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById (@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public void addANewBook (@RequestBody BookDTO book) {
        bookService.saveBook(book);
    }

    @PatchMapping("/{id}")
    public void changeBook (@PathVariable("id") long id, @RequestBody BookDTO book) {
        bookService.changeBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable("id") long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> getByRating (
            @RequestParam(name = "rat") Byte rating) {
        return bookService.findByGenre(rating);

    }

}
