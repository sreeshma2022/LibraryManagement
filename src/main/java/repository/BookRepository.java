package repository;

import model.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookRepository implements IBookRepository{

    private final Map<String , Book> bookCatalog = new HashMap<>();

    public Book saveBook(Book book){

        bookCatalog.put(book.getId() , book);
        return bookCatalog.get(book.getId());
    }

    public Book findBookById(String id){

        return bookCatalog.get(id);
    }

    public List<Book> findAllBooks(){

        return bookCatalog.values().stream().collect(Collectors.toList());
    }

    public Book deleteBookById(String id){
        Book book = bookCatalog.get(id);

        bookCatalog.remove(id);
        return book;


    }



}
