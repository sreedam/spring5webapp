package com.spring5web.spring5webapp.repositories;

import com.spring5web.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
