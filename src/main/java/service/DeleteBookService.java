package service;

import exceptions.BookNotFoundException;
import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

public class DeleteBookService implements IDeleteBookService{

    private final IBookRepository bookRepository;

    public DeleteBookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book deleteBook(String id) {
        if(bookRepository.findBookById(id)==null){
            throw new BookNotFoundException("Book not found!");
        }
        else{

            return bookRepository.deleteBookById(id);

        }
    }
}
