package ru.youdzhin.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.youdzhin.DTOs.AuthorDTO;
import ru.youdzhin.objects.Author;
import ru.youdzhin.objects.Book;
import ru.youdzhin.repositories.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public Author getById (Long id) {
        return repository.findById(id).get();
    }

    public List<Author> getAllAuthors () {
        return repository.findAll();
    }

    public void saveAuthor (AuthorDTO authorDTO) {
        repository.save(
                Author.builder()
                        .biography(authorDTO.biography())
                        .books(authorDTO.books())
                        .build()
        );
    }

    public void changeAuthor (long id, AuthorDTO authorDTO) {
        Author existingAuthor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        if (authorDTO.biography() != null) {
            existingAuthor.setBiography(authorDTO.biography());
        }
        else if (authorDTO.books() != null) {
            existingAuthor.setBooks(authorDTO.books());
        }

        repository.save(existingAuthor);
    }

    public void deleteAuthor (long id) {
        repository.deleteById(id);
    }

}
