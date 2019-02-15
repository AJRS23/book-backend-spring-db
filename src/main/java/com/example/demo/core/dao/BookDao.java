package com.example.demo.core.dao;

import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    public Book createBook(Book book);

    public Book updateBook(Book book);

    public List<Book> getBooks();

    public Book getBookById(String id);

    public Book getBookByNameAndAuthor(String name, String author);

    public void deleteBook(Book book);

}
