package ru.ico.ltd.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.ico.ltd.spring5webapp.model.Author;
import ru.ico.ltd.spring5webapp.model.Book;
import ru.ico.ltd.spring5webapp.model.Publisher;
import ru.ico.ltd.spring5webapp.repositories.AuthorRepository;
import ru.ico.ltd.spring5webapp.repositories.BookRepository;
import ru.ico.ltd.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        // populate data to db table
        Publisher publisher = new Publisher("Harper Collins", "NY, Wall St.");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Drive Design", "1234", publisher);
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Publisher publisher2 = new Publisher("Worx", "NY, Green St.");
        publisherRepository.save(publisher2);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2145", publisher2);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
