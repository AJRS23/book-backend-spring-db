package com.example.demo.core.dao;

import com.example.demo.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private List<Book> books;

    public BookDaoImpl() {
        this.books = new ArrayList<>();
    }

    @Override
    public Book createBook(Book book) {
        this.books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        Book bookToUpdate = this.getBookById(book.getId());
        bookToUpdate.setName(book.getName());
        bookToUpdate.setAuthor(book.getAuthor());
        return bookToUpdate;
    }

    @Override
    public List<Book> getBooks() {
        return this.books;
    }

    @Override
    public Book getBookById(String id) {
        Book bookToReturn = null;
        for (Book book : this.books) {
            if (book.getId().equals(id)) {
                bookToReturn = book;
                break;
            }
        }
        return bookToReturn;
    }

    @Override
    public Book getBookByNameAndAuthor(String name, String author) {
        Book bookToReturn = null;
        for (Book book : this.books) {
            if (book.getName().equals(name) && book.getAuthor().equals(author)) {
                bookToReturn = book;
                break;
            }
        }
        return bookToReturn;
    }

    @Override
    public void deleteBook(Book book) {
        this.books.remove(book);
    }
}
