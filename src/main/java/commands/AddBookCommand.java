package commands;

import model.Book;
import repository.BookRepository;
import service.IAddBookService;

import java.util.List;

public class AddBookCommand implements ICommand{

    private final IAddBookService addBookService;



    public AddBookCommand(IAddBookService addBookService) {
        this.addBookService = addBookService;
    }

    @Override
    public void execute(List<String> tokens) {

        Book book = addBookService.addBook(tokens.get(1),tokens.get(2),tokens.get(3),tokens.get(4),tokens.get(5));
        System.out.println("Book added successfully!!"  + " Book Details : " + book);
    }

    @Override
    public boolean isInputValid(List<String> tokens) {

        return tokens.size()==6;
    }
}
