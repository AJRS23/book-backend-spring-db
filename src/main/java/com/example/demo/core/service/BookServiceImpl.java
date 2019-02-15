package com.example.demo.core.service;

import com.example.demo.core.dao.IBookDao;
import com.example.demo.core.dto.dto;
import com.example.demo.model.Book;
import com.example.demo.support.exceptions.BookAlreadyExistsException;
import com.example.demo.support.exceptions.BookNameFieldRequiredException;
import com.example.demo.support.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    @Autowired
    private IBookDao iBookDao;

    public BookServiceImpl() {
    }


    @Transactional()
    @Override
    public Book createBook(String name, String author) throws Exception {
        if (name == null) {
            throw new BookNameFieldRequiredException();
        }
        dto book = this.iBookDao.findByNameAndAuthor(name, author);
        if (book != null) {
            throw new BookAlreadyExistsException();
        }
        book = new dto();
        //book.setId(UUID.randomUUID().toString());
        book.setName(name);
        book.setAuthor(author);
        //book = this.bookDao.createBook(book);
        book = this.iBookDao.save(book);
        Book newBook = new Book(book);
        return newBook;
    }

    @Transactional()
    @Override
    public Book updateBook(int id, String name, String author) throws Exception {
        if (name == null) {
            throw new BookNameFieldRequiredException();
        }
        dto book = this.iBookDao.findByNameAndAuthor(name, author);
        if (book != null && book.getId()!=(id)) {
            throw new BookAlreadyExistsException();
        }
        book = this.iBookDao.findById(id).orElse(null);
        if (book == null) {
            throw new BookNotFoundException();
        }
        book.setName(name);
        book.setAuthor(author);
        //book = this.bookDao.updateBook(book);
        book = this.iBookDao.save(book);
        Book newBook = new Book(book);
        return newBook;
    }

    @Override
    public List<Book> getBooks() {
        //List<Book> books = this.bookDao.getBooks();
        List<dto> books = this.iBookDao.findAll();
        return this.iBookDao.findAll().stream()
                .map(Book::new)
                .collect(Collectors.toList());
    }

    @Override
    public Book getBook(int id) throws Exception {
        //Book book = this.bookDao.getBookById(id);
        dto book = this.iBookDao.findById(id).orElse(null);
        if (book == null) {
            throw new BookNotFoundException();
        }
        Book newBook = new Book(book);
        return newBook;
    }

    @Override
    public void deleteBook(int id) throws Exception {
        //List<Book> books = this.bookDao.getBooks();
        List<dto> books = this.iBookDao.findAll();
        dto bookToDelete = null;
        for (dto book : books) {
            if (book.getId()==(id)) {
                bookToDelete = book;
                break;
            }
        }
        if (bookToDelete != null) {
            this.iBookDao.deleteById(bookToDelete.getId());
        }
        else {
            throw new BookNotFoundException();
        }
    }
}
