package service;

import exceptions.DuplicateBookException;
import exceptions.InvalidInputException;
import model.AvailabilityStatus;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import repository.BookRepository;
import repository.IBookRepository;
import service.AddBookService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AddBookServiceTest {

    private AddBookService addBookService;
    private BookRepository bookRepository = new BookRepository();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        addBookService = new AddBookService(bookRepository);
    }

    @Test
    public void addBook_ShouldAddBook_WhenValidInputsProvided() {
        // Arrange
        String id = "1";
        String title = "Effective Java";
        String author = "Joshua Bloch";
        String genre = "Programming";
        String availability = "Available";




        // Act
        Book addedBook = addBookService.addBook(id, title, author, genre, availability);

        // Assert
        assertNotNull(addedBook);
        assertEquals(id, addedBook.getId());
        assertEquals(title, addedBook.getTitle());
        assertEquals(author, addedBook.getAuthor());
        assertEquals(genre, addedBook.getGenre());
        assertEquals(AvailabilityStatus.AVAILABLE, addedBook.getAvailability());


    }

    @Test(expected = DuplicateBookException.class)
    public void addBook_ShouldThrowDuplicateBookException_WhenBookIdAlreadyExists() {
        // Arrange
        String id = "1";
        addBookService.addBook(id, "Old Book", "Old Author", "Old Genre", "AVAILABLE");

        // Act
        addBookService.addBook(id, "New Book", "New Author", "New Genre", "Available");
    }

    @Test(expected = InvalidInputException.class)
    public void addBook_ShouldThrowInvalidInputException_WhenInvalidInputsProvided() {
        // Arrange
        String id = "2";
        String title = "";
        String author = "";
        String genre = "Science";
        String availability = "InvalidStatus";



        // Act
        addBookService.addBook(id, title, author, genre, availability);
    }
}
