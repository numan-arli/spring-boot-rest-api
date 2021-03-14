package com.telebilgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telebilgi.model.Books;

public interface BookRepository2 extends JpaRepository<Books, Integer> {

}
