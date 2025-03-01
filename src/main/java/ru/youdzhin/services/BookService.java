package ru.youdzhin.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.youdzhin.DTOs.BookDTO;
import ru.youdzhin.objects.Book;
import ru.youdzhin.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository repository;

    public List<Book> getAllBooks () {
        return repository.findAll();
    }

    public void saveBook (BookDTO book) {
        repository.save(
                Book.builder()
                        .author(book.author())
                        .genre(book.genre())
                        .yearOfPublication(book.yearOfPublication())
                        .description(book.description())
                        .status(book.status())
                        .rating(book.rating())
                        .build()
        );
    }

    public Book getBookById (Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

}
