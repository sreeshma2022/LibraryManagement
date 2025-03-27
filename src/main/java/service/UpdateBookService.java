package service;

import exceptions.BookNotFoundException;
import exceptions.InvalidInputException;
import model.AvailabilityStatus;
import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

public class UpdateBookService implements IUpdateBookService{

    private final IBookRepository bookRepository;

    public UpdateBookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book updateBook(String id, String title, String author, String availability) {
        Book book = bookRepository.findBookById(id);
        if(book == null){
            throw new BookNotFoundException("Book not found");
        }
        if (title.isEmpty() || author.isEmpty() || !AvailabilityStatus.isValid(availability)){
          throw new InvalidInputException("Title and author cannot be null, AvailabilityStatus should be  available or checked_out");
        }
        if (!title.isEmpty()) {
            book.setTitle(title);
        }
        if (!author.isEmpty()) book.setAuthor(author);
        if (AvailabilityStatus.isValid(availability)) {
            book.setAvailability(AvailabilityStatus.valueOf(availability.toUpperCase().replace(" ", "_")));
        }
        return bookRepository.saveBook(book);


    }
}
