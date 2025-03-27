import commands.CommandInvoker;
import config.ApplicationConfig;
import repository.BookRepository;
import repository.IBookRepository;
import service.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        ApplicationConfig appConfig = new ApplicationConfig();
        CommandInvoker commandInvoker = appConfig.getCommandInvoker();



        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nLibrary System Menu:");
                System.out.println("1. Add Book" + "  eg: ADD_BOOK book_id title author genre available|checked_out");
                System.out.println("2. View All Books" + " eg: VIEW_BOOKS");
                System.out.println("3. Search Book" + " eg: SEARCH_BOOK book_id|title");
                System.out.println("4. Update Book" + " eg: UPDATE_BOOK book_id title author available|checked_out");
                System.out.println("5. Delete Book" + " eg: DELETE_BOOK book_id");
                System.out.println("6. Exit" + "eg: exit");
                System.out.print("Choose an option: ");

                String input = scanner.nextLine();
                List<String> arguments = Arrays.asList(input.split(" "));
                String commandName = arguments.get(0);
                if (commandName.equalsIgnoreCase("EXIT")) {
                    break;
                }

                List<String> tokens = arguments.size() > 1 ? arguments.subList(1, arguments.size()) : Collections.emptyList();
                commandInvoker.executeCommand(commandName, arguments);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


}
