package service;

import model.AvailabilityStatus;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import repository.BookRepository;
import service.ViewBookService;

import java.util.List;

import static org.junit.Assert.*;

public class ViewBookServiceTest {

    private ViewBookService viewBookService;
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new BookRepository();  // Using real repository
        viewBookService = new ViewBookService(bookRepository);

        // Adding sample books to repository
        bookRepository.saveBook(new Book("1", "Java Basics", "Author A", "Education", AvailabilityStatus.AVAILABLE));
        bookRepository.saveBook(new Book("2", "Python Guide", "Author B", "Technology", AvailabilityStatus.CHECKED_OUT));
    }

    @Test
    public void testViewBooks_ReturnsAllBooks() {
        // When
        List<Book> books = viewBookService.viewBooks();

        // Then
        assertNotNull(books);
        assertEquals(2, books.size());
    }


}
