package com.rc.spring.controller;

import com.rc.spring.model.Book;
import com.rc.spring.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping("/book/{id}")
  public Book bookById(@PathVariable int id){
    return bookRepository.findById(id);
  }

  @GetMapping("/book")
  public List<Book> allBooks() {
    return bookRepository.findAll();
  }

  @PostMapping("/book")
  public ResponseEntity<String> addBook(@RequestBody Book book) {
    try {
      bookRepository.save(Book.builder().name(book.getName()).description(book.getDescription()).build());
      return new ResponseEntity<>("Successful!", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
