package config;

import commands.*;
import repository.BookRepository;
import repository.IBookRepository;
import service.*;

public class ApplicationConfig {
    private final IBookRepository bookRepository = new BookRepository();

    private final IDeleteBookService deleteBookService = new DeleteBookService(bookRepository);
    private final IAddBookService addBookService = new AddBookService(bookRepository);
    private final IViewBookService viewBookService = new ViewBookService(bookRepository);
    private final ISearchBookService searchBookService = new SearchBookService(bookRepository);
    private final IUpdateBookService updateBookService = new UpdateBookService(bookRepository);

    private final ICommand addBookCommand = new AddBookCommand(addBookService);
    private final ICommand deleteBookCommand = new DeleteBookCommand(deleteBookService);
    private final ICommand updateBookCommand = new UpdateBookCommand(updateBookService);
    private final ICommand viewBookCommand = new ViewBookCommand(viewBookService);
    private final ICommand searchBookCommand = new SearchBookCommand(searchBookService);


    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {

        commandInvoker.register("ADD_BOOK",addBookCommand);
        commandInvoker.register("VIEW_BOOKS",viewBookCommand);
        commandInvoker.register("DELETE_BOOK",deleteBookCommand);
        commandInvoker.register("SEARCH_BOOK",searchBookCommand);
        commandInvoker.register("UPDATE_BOOK",updateBookCommand);


        return commandInvoker;
    }
}
