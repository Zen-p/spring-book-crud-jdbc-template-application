package ru.youdzhin.services;


import org.springframework.stereotype.Service;
import ru.youdzhin.DTOs.AuthorDTO;
import ru.youdzhin.objects.Author;


import java.util.List;

@Service
public class AuthorService {


    public Author getById (Long id) {
        return null;
    }

    public List<Author> getAllAuthors () {
        return null;
    }

    public void saveAuthor (AuthorDTO authorDTO) {

    }

    public void changeAuthor (long id, AuthorDTO authorDTO) {

    }

    public void deleteAuthor (long id) {
    }

}
