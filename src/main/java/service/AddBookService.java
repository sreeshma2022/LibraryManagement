package service;

import exceptions.DuplicateBookException;
import exceptions.InvalidInputException;
import model.AvailabilityStatus;
import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

public class AddBookService implements IAddBookService{

    private final IBookRepository bookRepository;

    public AddBookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(String id, String title, String author, String genre, String availability) {

        if(bookRepository.findBookById(id)!= null){
            throw new DuplicateBookException("Book  with id " + id + " already exists");
        }
        if(title.isEmpty() || author.isEmpty() || !AvailabilityStatus.isValid(availability)){
            throw new InvalidInputException("Please provide valid inputs and try again !");
        }


        return bookRepository.saveBook(new Book(id,title,author,genre,AvailabilityStatus.valueOf(availability.toUpperCase().replace(" ", "_"))));


    }
}
