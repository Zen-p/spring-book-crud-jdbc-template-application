package ru.youdzhin.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.youdzhin.DTOs.BookDTO;
import ru.youdzhin.objects.Book;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {


    public List<Book> getAllBooks () {
        return null;
    }

    public void saveBook (BookDTO book) {

    }

    public Book getBookById (Long id) {
        return null;
    }

    public void changeBook(long id, BookDTO book) {

    }


    public void deleteBook (long id) {
    }

    public List<Book> findByGenre (byte rat) {
        return null;
    }

}
