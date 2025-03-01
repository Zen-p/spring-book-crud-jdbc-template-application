package ru.youdzhin.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.youdzhin.objects.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
