package com.spring5web.spring5webapp.bootstrap;

import com.spring5web.spring5webapp.model.Author;
import com.spring5web.spring5webapp.model.Book;
import com.spring5web.spring5webapp.model.Publisher;
import com.spring5web.spring5webapp.repositories.AuthorRepository;
import com.spring5web.spring5webapp.repositories.BookRepository;
import com.spring5web.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class Devbootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
   private PublisherRepository publisherRepository;

    public Devbootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData()
    {
        Publisher publisher = new Publisher("Harper Collins","Bangalore indiranagar");
        publisherRepository.save(publisher);
        Author eric = new Author("eric","evans");

        Book ddd = new Book("Domain Driven Design","1234",publisher);
        eric.getBooks().add(ddd);

        ddd.getAuthors().add(eric);

        authorRepository.save(eric);

        bookRepository.save(ddd);

        Publisher publisher1 = new Publisher("Sreedam","MG Road Neorems");
        publisherRepository.save(publisher1);
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","22334",publisher1);

        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
