package service;

import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

import java.util.Collection;
import java.util.List;

public class ViewBookService implements  IViewBookService{

    private final IBookRepository bookRepository;

    public ViewBookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> viewBooks() {

        return bookRepository.findAllBooks();
    }
}
