package service;

import model.Book;
import repository.BookRepository;

public interface IAddBookService {

    Book addBook(String id, String title, String author, String genre, String availability);
}
