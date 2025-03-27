package service;

import model.Book;
import repository.BookRepository;

public interface IUpdateBookService {

    Book updateBook(String id, String title, String author, String availability);
}
