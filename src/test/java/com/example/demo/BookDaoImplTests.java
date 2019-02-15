package com.example.demo;

import com.example.demo.core.dao.BookDao;
import com.example.demo.core.dao.BookDaoImpl;
import com.example.demo.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoImplTests {

    private BookDao bookDao;

    @Before
    public void setBookDao() {
        this.bookDao = new BookDaoImpl();
    }

    @Test
    public void test_createBookSuccessful() {
        Book finalObject = new Book("name", "author");
        Book book = this.bookDao.createBook(finalObject);
        Assert.assertEquals(finalObject.getName(), book.getName());
        Assert.assertEquals(finalObject.getAuthor(), book.getAuthor());
    }

    @Test
    public void test_updateBookSuccessful() {
        Book finalObject = new Book("name", "author");
        Book book = this.bookDao.createBook(finalObject);
        book.setName("newName");
        book.setAuthor("newAuthor");
        book = this.bookDao.updateBook(book);
        Assert.assertEquals("newName", book.getName());
        Assert.assertEquals("newAuthor", book.getAuthor());
    }

    @Test
    public void test_getBooksSuccessful() {
        List<Book> books = this.bookDao.getBooks();
        Assert.assertTrue(books instanceof List);
    }

    @Test
    public void test_getBookByIdSuccessful() {
        Book finalObject = new Book("name", "author");
        Book book = this.bookDao.createBook(finalObject);
        book = this.bookDao.getBookById(book.getId());
        Assert.assertEquals(finalObject.getName(), book.getName());
        Assert.assertEquals(finalObject.getAuthor(), book.getAuthor());
    }

    @Test
    public void test_getNonExistentBookById() {
        Book book = this.bookDao.getBookById("0");
        Assert.assertNull(book);
    }

    @Test
    public void test_getBookByNameAndAuthorSuccessful() {
        Book finalObject = new Book("name", "author");
        Book otherBook = new Book("name2", "author2");
        this.bookDao.createBook(otherBook);
        this.bookDao.createBook(finalObject);
        Book book = this.bookDao.getBookByNameAndAuthor(finalObject.getName(), finalObject.getAuthor());
        Assert.assertEquals(finalObject.getName(), book.getName());
        Assert.assertEquals(finalObject.getAuthor(), book.getAuthor());
    }

    @Test
    public void test_getNonExistentBookByNameAndAuthor() {
        Book finalObject = new Book("name", "author");
        Book book = this.bookDao.getBookByNameAndAuthor(finalObject.getName(), finalObject.getAuthor());
        Assert.assertNull(book);
    }

    @Test
    public void test_deleteBookSuccessful() {
        Book finalObject = new Book("name", "author");
        Book otherBook = new Book("name2", "author2");
        this.bookDao.createBook(otherBook);
        Book book = this.bookDao.createBook(finalObject);
        this.bookDao.deleteBook(book);
        book = this.bookDao.getBookById(book.getId());
        Assert.assertNull(book);
    }
}
