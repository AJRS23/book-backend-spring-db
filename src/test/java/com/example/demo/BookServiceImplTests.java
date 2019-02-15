//package com.example.demo;
//
//import com.example.demo.core.dao.BookDaoImpl;
//import com.example.demo.core.service.BookService;
//import com.example.demo.core.service.BookServiceImpl;
//import com.example.demo.model.Book;
//import com.example.demo.support.exceptions.BookAlreadyExistsException;
//import com.example.demo.support.exceptions.BookNameFieldRequiredException;
//import com.example.demo.support.exceptions.BookNotFoundException;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import static org.mockito.Mockito.when;
//
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class BookServiceImplTests {
//
//    @Mock
//    private BookDaoImpl bookDaoImplMock;
//
//    @InjectMocks
//    private static BookService bookService;
//
//    @BeforeClass
//    public static void setup() {
//        bookService = new BookServiceImpl();
//    }
//
//    @Test
//    public void test_createBookSuccessful() {
//        Book finalObject = new Book();
//        finalObject.setId(UUID.randomUUID().toString());
//        finalObject.setName("name");
//        finalObject.setAuthor("author");
//
//        when(bookDaoImplMock.getBookByNameAndAuthor(Mockito.any(), Mockito.any())).thenReturn(null);
//        when(bookDaoImplMock.createBook(Mockito.any(Book.class))).thenReturn(new Book(finalObject.getName(),
//                finalObject.getAuthor()));
//
//        try {
//            Book book = bookService.createBook(finalObject.getName(), finalObject.getAuthor());
//            Assert.assertEquals(finalObject.getName(), book.getName());
//            Assert.assertEquals(finalObject.getAuthor(), book.getAuthor());
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//    }
//
//    @Test
//    public void test_createBookNoName() {
//        boolean reachedException = false;
//
//        try {
//            bookService.createBook(null, "author");
//        }
//        catch (BookNameFieldRequiredException e) {
//            reachedException = true;
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        Assert.assertTrue(reachedException);
//    }
//
//    @Test
//    public void test_createBookRepeatedValues() {
//        Book finalObject = new Book();
//        finalObject.setId(UUID.randomUUID().toString());
//        finalObject.setName("name");
//        finalObject.setAuthor("author");
//
//        boolean reachedException = false;
//        when(bookDaoImplMock.getBookByNameAndAuthor(Mockito.any(), Mockito.any())).thenReturn(finalObject);
//
//        try {
//            bookService.createBook(finalObject.getName(), finalObject.getAuthor());
//        }
//        catch (BookAlreadyExistsException e) {
//            reachedException = true;
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        Assert.assertTrue(reachedException);
//    }
//
//    @Test
//    public void test_updateBookSuccessful() {
//        Book finalObject = new Book();
//        finalObject.setId(UUID.randomUUID().toString());
//        finalObject.setName("name");
//        finalObject.setAuthor("author");
//
//        when(bookDaoImplMock.getBookByNameAndAuthor(Mockito.any(), Mockito.any())).thenReturn(null);
//        when(bookDaoImplMock.getBookById(Mockito.any(String.class))).thenReturn(
//                new Book(finalObject.getName(), finalObject.getAuthor())
//        );
//        when(bookDaoImplMock.updateBook(Mockito.any(Book.class))).thenReturn(
//                new Book("newName", "newAuthor")
//        );
//
//        try {
//            Book book = bookService.updateBook(finalObject.getId(), "newName", "newAuthor");
//            Assert.assertEquals("newName", book.getName());
//            Assert.assertEquals("newAuthor", book.getAuthor());
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//    }
//
//    @Test
//    public void test_updateNonExistentBook() {
//        Book finalObject = new Book();
//        finalObject.setId(UUID.randomUUID().toString());
//        finalObject.setName("name");
//        finalObject.setAuthor("author");
//
//        boolean reachedException = false;
//        when(bookDaoImplMock.getBookByNameAndAuthor(Mockito.any(), Mockito.any())).thenReturn(finalObject);
//        when(bookDaoImplMock.getBookById(Mockito.any())).thenReturn(
//                null
//        );
//
//        try {
//            bookService.updateBook(finalObject.getId(), "newName", "newAuthor");
//        }
//        catch (BookNotFoundException e) {
//            reachedException = true;
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        Assert.assertTrue(reachedException);
//    }
//
//    @Test
//    public void test_updateBookRepeatedValues() {
//        Book finalObject = new Book();
//        finalObject.setId(UUID.randomUUID().toString());
//        finalObject.setName("name");
//        finalObject.setAuthor("author");
//
//        boolean reachedException = false;
//        when(bookDaoImplMock.getBookByNameAndAuthor(Mockito.any(), Mockito.any())).thenReturn(finalObject);
//
//        try {
//            bookService.updateBook("otherId", finalObject.getName(), finalObject.getAuthor());
//        }
//        catch (BookAlreadyExistsException e) {
//            reachedException = true;
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        Assert.assertTrue(reachedException);
//    }
//
//    @Test
//    public void test_updateBookNoName() {
//        boolean reachedException = false;
//
//        try {
//            bookService.updateBook("1",null, "author");
//        }
//        catch (BookNameFieldRequiredException e) {
//            reachedException = true;
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        Assert.assertTrue(reachedException);
//    }
//
//    @Test
//    public void test_getAllBooksSuccessful() {
//        when(bookDaoImplMock.getBooks()).thenReturn(new ArrayList<Book>());
//
//        List<Book> books = bookService.getBooks();
//        Assert.assertTrue(books instanceof List);
//    }
//
//    @Test
//    public void test_getBookByIdSuccessful() {
//        Book finalObject = new Book();
//        finalObject.setId(UUID.randomUUID().toString());
//        finalObject.setName("name");
//        finalObject.setAuthor("author");
//
//        when(bookDaoImplMock.getBookById(Mockito.any())).thenReturn(
//                new Book(finalObject.getName(), finalObject.getAuthor())
//        );
//
//        try {
//            Book book = bookService.getBook(finalObject.getId());
//            Assert.assertEquals(finalObject.getName(), book.getName());
//            Assert.assertEquals(finalObject.getAuthor(), book.getAuthor());
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//    }
//
//    @Test
//    public void test_getBookByIdFail() {
//        boolean reachedException = false;
//        when(bookDaoImplMock.getBookById(Mockito.any())).thenReturn(
//                null
//        );
//
//        try {
//            bookService.getBook("1");
//        }
//        catch (BookNotFoundException e) {
//            reachedException = true;
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        Assert.assertTrue(reachedException);
//    }
//
//    @Test
//    public void test_deleteBookSuccessful() {
//        Book finalObject = new Book();
//        finalObject.setId(UUID.randomUUID().toString());
//        finalObject.setName("name");
//        finalObject.setAuthor("author");
//
//        boolean noException = false;
//        when(bookDaoImplMock.getBooks()).thenReturn(new ArrayList<Book>(){
//            {
//                add(new Book("name2", "author2"));
//                add(finalObject);
//            }
//        });
//        when(bookDaoImplMock.getBookById(Mockito.any(String.class))).thenReturn(
//                new Book(finalObject.getName(), finalObject.getAuthor())
//        );
//
//        try {
//            bookService.deleteBook(finalObject.getId());
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        try {
//            bookService.getBook(finalObject.getId());
//            noException = true;
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        Assert.assertTrue(noException);
//    }
//
//    @Test
//    public void test_deleteNonExistentBook() {
//        boolean reachedException = false;
//        when(bookDaoImplMock.getBooks()).thenReturn(new ArrayList<Book>());
//
//        try {
//            bookService.deleteBook("0");
//        }
//        catch (BookNotFoundException e) {
//            reachedException = true;
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//        Assert.assertTrue(reachedException);
//    }
//}
