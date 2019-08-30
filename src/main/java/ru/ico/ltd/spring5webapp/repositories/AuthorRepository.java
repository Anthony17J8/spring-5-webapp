package ru.ico.ltd.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ico.ltd.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
