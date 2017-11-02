package com.spring5web.spring5webapp.repositories;

import com.spring5web.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
