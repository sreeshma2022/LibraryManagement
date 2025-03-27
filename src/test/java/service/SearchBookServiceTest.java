package service;

import exceptions.BookNotFoundException;
import model.AvailabilityStatus;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import repository.BookRepository;
import service.SearchBookService;

import static org.junit.Assert.*;

public class SearchBookServiceTest {

    private SearchBookService searchBookService;
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new BookRepository();  // Using real repository
        searchBookService = new SearchBookService(bookRepository);

        // Adding sample books to repository
        bookRepository.saveBook(new Book("1", "Java Programming", "Author A", "Education", AvailabilityStatus.AVAILABLE));
        bookRepository.saveBook(new Book("2", "Python Basics", "Author B", "Technology", AvailabilityStatus.CHECKED_OUT));
    }

    @Test
    public void testSearchBookById_Success() {
        // When
        Book foundBook = searchBookService.searchBook("1");

        // Then
        assertNotNull(foundBook);
        assertEquals("1", foundBook.getId());
        assertEquals("Java Programming", foundBook.getTitle());
    }

    @Test
    public void testSearchBookByTitle_Success() {
        // When
        Book foundBook = searchBookService.searchBook("Python Basics");

        // Then
        assertNotNull(foundBook);
        assertEquals("2", foundBook.getId());
        assertEquals("Python Basics", foundBook.getTitle());
    }

    @Test(expected = BookNotFoundException.class)
    public void testSearchBook_BookNotFound() {
        // When
        searchBookService.searchBook("Nonexistent Book");

        // Then - Should throw BookNotFoundException
    }
}
