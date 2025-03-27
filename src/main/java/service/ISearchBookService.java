package service;

import model.Book;
import repository.BookRepository;

public interface ISearchBookService {

    Book searchBook(String query);
}
