package ru.youdzhin.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.youdzhin.objects.Author;
import ru.youdzhin.repositories.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public Author getById (Long id) {
        return repository.findById(id).get();
    }

}
