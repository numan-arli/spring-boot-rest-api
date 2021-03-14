package com.telebilgi.repository;

import org.springframework.data.repository.CrudRepository;

import com.telebilgi.model.Books;

public interface BookRepository extends CrudRepository<Books, Integer> {

}
