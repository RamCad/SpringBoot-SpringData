package com.rc.spring.repository;

import com.rc.spring.model.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {

  @Autowired
  private JdbcTemplate template;

  @Override
  public Book findById(int id) {
    return template.queryForObject("SELECT * FROM book WHERE id=?",
        BeanPropertyRowMapper.newInstance(Book.class), id);
  }

  @Override
  public int save(Book book) {
    return template.update("INSERT INTO book (name, description) VALUES(?,?)",
        new Object[] { book.getName(), book.getDescription() });
  }

  @Override
  public int update(Book book) {
    return template.update("UPDATE book SET name=?, description=? WHERE id=?",
        new Object[] { book.getName(), book.getDescription(), book.getId() });
  }

  @Override
  public int deleteById(int id) {
    return template.update("DELETE FROM book WHERE id=?", id);
  }

  @Override
  public List<Book> findAll() {
    return template.query("SELECT * from book", BeanPropertyRowMapper.newInstance(Book.class));
  }

  @Override
  public int deleteAll() {
    return template.update("DELETE from tutorials");
  }

  @Override
  public List<Book> findByName(String name) {
    return template.query("SELECT * from book WHERE name ILIKE '%" + name + "%'", BeanPropertyRowMapper.newInstance(Book.class));
  }
}
