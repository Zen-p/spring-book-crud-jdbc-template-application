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
                        .authors(book.author())
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

    public void changeBook(long id, BookDTO book) {
        Book existingBook = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Обновляем только те поля, которые переданы в запросе
        if (book.author() != null) {
            existingBook.setAuthors(book.author());
        }
        if (book.genre() != null) {
            existingBook.setGenre(book.genre());
        }
        if (book.yearOfPublication() != null) {
            existingBook.setYearOfPublication(book.yearOfPublication());
        }
        if (book.description() != null) {
            existingBook.setDescription(book.description());
        }
        if (book.status() != null) {
            existingBook.setStatus(book.status());
        }
        if (book.rating() != null) {
            existingBook.setRating(book.rating());
        }

        repository.save(existingBook);
    }


    public void deleteBook (long id) {
        repository.deleteById(id);
    }

    public List<Book> findByGenre (byte rat) {
        return repository.findAllByRating(rat);
    }

}
