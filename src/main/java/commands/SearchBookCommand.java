package commands;

import model.Book;
import service.ISearchBookService;

import java.util.List;

public class SearchBookCommand implements ICommand{

    private final ISearchBookService searchBookService;

    public SearchBookCommand(ISearchBookService searchBookService) {
        this.searchBookService = searchBookService;
    }

    @Override
    public void execute(List<String> tokens) {

        Book book = searchBookService.searchBook(tokens.get(1));
        System.out.println("Book Details: " + book);
    }

    @Override
    public boolean isInputValid(List<String> tokens) {
        return tokens.size()==2;
    }
}
