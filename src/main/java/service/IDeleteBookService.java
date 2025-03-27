package service;

import model.Book;
import repository.BookRepository;

public interface IDeleteBookService {

    Book deleteBook(String id);
}
