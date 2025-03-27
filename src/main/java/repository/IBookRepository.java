package repository;

import model.Book;

import java.util.Collection;
import java.util.List;

public interface IBookRepository {

    Book saveBook(Book book);
    Book findBookById(String id);
    List<Book> findAllBooks();
    Book deleteBookById(String id);
}
