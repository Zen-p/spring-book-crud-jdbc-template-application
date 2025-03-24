package ru.youdzhin.services;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.youdzhin.DTOs.BookDTO;
import ru.youdzhin.objects.Author;
import ru.youdzhin.objects.Book;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks () {
        return null;
    }

    public void saveBook (BookDTO book) {
        var sql = "INSERT INTO author (biography)" +
                "VALUES (?)";
        for (Author author : book.author()) {
//            System.out.println(author.getId());
            jdbcTemplate.update(sql, author.getBiography());
        }
        sql = "INSERT INTO book(year_of_publication, description, status, rating) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                book.yearOfPublication(),
                book.description(),
                book.status(),
                book.rating());
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
