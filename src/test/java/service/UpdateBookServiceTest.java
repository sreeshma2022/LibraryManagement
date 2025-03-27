package service;

import exceptions.BookNotFoundException;
import exceptions.InvalidInputException;
import model.AvailabilityStatus;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import repository.BookRepository;
import service.UpdateBookService;

import static org.junit.Assert.*;

public class UpdateBookServiceTest {

    private UpdateBookService updateBookService;
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new BookRepository();  // Using real repository
        updateBookService = new UpdateBookService(bookRepository);

        // Adding a sample book to repository
        bookRepository.saveBook(new Book("1", "Old Title", "Old Author", "Fiction", AvailabilityStatus.AVAILABLE));
    }

    @Test
    public void testUpdateBook_Success() {
        // When
        Book updatedBook = updateBookService.updateBook("1", "New Title", "New Author", "Checked_Out");

        // Then
        assertNotNull(updatedBook);
        assertEquals("New Title", updatedBook.getTitle());
        assertEquals("New Author", updatedBook.getAuthor());
        assertEquals(AvailabilityStatus.CHECKED_OUT, updatedBook.getAvailability());
    }

    @Test(expected = BookNotFoundException.class)
    public void testUpdateBook_BookNotFound() {
        // When
        updateBookService.updateBook("2", "New Title", "New Author", "Available");

        // Then - Should throw BookNotFoundException
    }

    @Test(expected = InvalidInputException.class)
    public void testUpdateBook_InvalidInput() {
        // When
        updateBookService.updateBook("1", "", "", "Invalid_Status");

        // Then - Should throw InvalidInputException
    }
}
