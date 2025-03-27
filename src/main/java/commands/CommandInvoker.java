package commands;
import exceptions.InvalidInputException;
import exceptions.NoSuchCommandException;

import java.util.*;


public class CommandInvoker {

    private static final Map<String, ICommand> commandMap = new HashMap<>();

    // Register the command into the HashMap
    public void register(String commandName, ICommand command){
        commandMap.put(commandName,command);
    }

    // Get the registered Command
    private ICommand get(String commandName){
        return commandMap.get(commandName);
    }

    // Execute the registered Command
    public void executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        ICommand command = get(commandName);
        if(command == null){
            // Handle Exception
            throw new NoSuchCommandException(commandName + " No such command");
        }
        if(command.isInputValid(tokens)) {
            command.execute(tokens);
        }
        else{
            throw new InvalidInputException("Please provide valid inputs");
        }
    }

}
