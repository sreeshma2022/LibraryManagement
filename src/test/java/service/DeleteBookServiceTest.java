package service;

import exceptions.BookNotFoundException;
import model.AvailabilityStatus;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import repository.BookRepository;
import service.DeleteBookService;

import static org.junit.Assert.*;

public class DeleteBookServiceTest {

    private DeleteBookService deleteBookService;
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new BookRepository();  // Using real repository
        deleteBookService = new DeleteBookService(bookRepository);

        // Adding a sample book to repository
        bookRepository.saveBook(new Book("1", "Sample Title", "Sample Author", "Fiction", AvailabilityStatus.AVAILABLE));
    }

    @Test
    public void testDeleteBook_Success() {
        // When
        Book deletedBook = deleteBookService.deleteBook("1");

        // Then
        assertNotNull(deletedBook);
        assertEquals("1", deletedBook.getId());
        assertNull(bookRepository.findBookById("1")); // Book should be deleted
    }

    @Test(expected = BookNotFoundException.class)
    public void testDeleteBook_BookNotFound() {
        // When
        deleteBookService.deleteBook("2");

        // Then - Should throw BookNotFoundException
    }
}
