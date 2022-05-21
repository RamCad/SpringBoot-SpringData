package com.rc.spring.repository;

import com.rc.spring.model.Book;
import java.util.List;

public interface BookRepository {
  Book findById(int id);
  int save(Book book);
  int update(Book book);
  int deleteById(int id);
  List<Book> findAll();
  int deleteAll();
  List<Book> findByName(String name);

}
