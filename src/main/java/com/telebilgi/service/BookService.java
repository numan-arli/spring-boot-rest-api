package com.telebilgi.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.telebilgi.model.Books;
import com.telebilgi.repository.BookRepository;
import com.telebilgi.repository.BookRepository2;

@Service
public class BookService {
	@Autowired
	BookRepository booksRepository;
		
	@Autowired
	JdbcTemplate template;
	
	//@Autowired
	//HibernateTemplate template2;
	
	//@Autowired
	//private SessionFactory sessionFactory;
	
	public List<Books> getallbooks(){
		List<Books> books=new ArrayList<Books>();
	   booksRepository.findAll().forEach(books::add);
		return books;
	}
	
	public void saveStudent(Books book) {
	 booksRepository.save(book);

	}
	
	public Books getById(int bookId) {
		Books book=new Books();
		book= booksRepository.findById(bookId).get();
		return book;
	}
	
	public void updateBook(Books book) {
      
     booksRepository.save(book);
      
	}
	
	public void deleteByJdbc(int id) {
		String query="delete from Books where bookid='"+id+"'";
		template.update(query);
		
	}
	
	
	/*
	 * public void deleteMethod(int id) { // booksRepository.deleteById(id);
	 * bookRepository2.deleteAllInBatch(); }
	 * 
	 * 
	 * public void deleteByEntity(Books book) { booksRepository.delete(book);
	 * bookRepository2.deleteById(null); }
	 */
	
	
	

}
