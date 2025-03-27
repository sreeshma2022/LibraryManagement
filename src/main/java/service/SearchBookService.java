package service;

import exceptions.BookNotFoundException;
import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

public class SearchBookService implements ISearchBookService{

    private final IBookRepository bookRepository;

    public SearchBookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book searchBook(String query) {
        for (Book book : bookRepository.findAllBooks()) {
            if (book.getId().equals(query) || book.getTitle().equalsIgnoreCase(query)) {
                return book;
            }
        }
        throw new BookNotFoundException( "Book with Id or title matching value " + query +  " not found.");
    }
}
