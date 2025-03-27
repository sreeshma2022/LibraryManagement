package commands;

import model.Book;
import service.IDeleteBookService;

import java.util.List;

public class DeleteBookCommand implements ICommand{

    private final IDeleteBookService deleteBookService;

    public DeleteBookCommand(IDeleteBookService deleteBookService) {
        this.deleteBookService = deleteBookService;
    }

    @Override
    public void execute(List<String> tokens) {

        Book book = deleteBookService.deleteBook(tokens.get(1));
        System.out.println("Book deleted successfully " + book);
    }

    @Override
    public boolean isInputValid(List<String> tokens) {
        return tokens.size()==2;
    }
}
