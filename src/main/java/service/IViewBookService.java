package service;

import model.Book;
import repository.BookRepository;

import java.util.Collection;
import java.util.List;

public interface IViewBookService {

    List<Book> viewBooks();
}
