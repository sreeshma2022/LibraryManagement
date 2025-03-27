package commands;

import model.Book;
import service.IViewBookService;

import java.util.Collection;
import java.util.List;

public class ViewBookCommand implements ICommand{

    private final IViewBookService viewBookService;

    public ViewBookCommand(IViewBookService viewBookService) {
        this.viewBookService = viewBookService;
    }

    @Override
    public void execute(List<String> tokens) {

        List<Book> books = viewBookService.viewBooks();
        System.out.println("Book Catalog: " + books);
    }

    @Override
    public boolean isInputValid(List<String> tokens) {
        return true;
    }
}
