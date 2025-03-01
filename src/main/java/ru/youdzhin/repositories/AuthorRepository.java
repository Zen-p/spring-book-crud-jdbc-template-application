package ru.youdzhin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.youdzhin.objects.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
