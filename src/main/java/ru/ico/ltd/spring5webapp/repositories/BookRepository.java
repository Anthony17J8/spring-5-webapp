package ru.ico.ltd.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ico.ltd.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
