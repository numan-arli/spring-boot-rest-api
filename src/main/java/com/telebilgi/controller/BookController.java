package com.telebilgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telebilgi.model.Books;
import com.telebilgi.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Books> getallbooks() {	
		return bookService.getallbooks();	
			
	}
	
	@PostMapping ("/books")
	public int postBook(@RequestBody Books book) {
		 bookService.saveStudent(book);
		 return book.getBookid();
	}
	
	@GetMapping("/books/{id}")
	public Books getById(@PathVariable int id) {
		return bookService.getById(id);
	}
	
	
	  @DeleteMapping("/books/{id}")
	  public void deleteBooks(@PathVariable int id) {
	  
		  Books book=new Books();
		book= bookService.getById(id);
	    if(book==null) {
			  
			  throw new BookNotFoundException("book id is not found: "+id);
	  }
		  
		  bookService.deleteByJdbc(id);
	  
	  }
	 
	
	/*
	 * @DeleteMapping("/books") public void deleteBookByEnti(@RequestBody Books
	 * book) { bookService.
	 * 
	 * }
	 */
		
	@PutMapping("/books")
	public Books updateBook(@RequestBody Books book) {
	bookService.updateBook(book);
	return book;
	}

}
