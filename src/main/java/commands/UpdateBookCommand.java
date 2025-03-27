package commands;

import model.Book;
import service.IUpdateBookService;

import java.util.List;

public class UpdateBookCommand implements ICommand{

    private final IUpdateBookService updateBookService;

    public UpdateBookCommand(IUpdateBookService updateBookService) {
        this.updateBookService = updateBookService;
    }

    @Override
    public void execute(List<String> tokens) {
        Book book = updateBookService.updateBook(tokens.get(1),tokens.get(2),tokens.get(3),tokens.get(4));
        System.out.println("Book updated successfully! " + book);

    }

    @Override
    public boolean isInputValid(List<String> tokens) {
        return tokens.size()==5;
    }
}
