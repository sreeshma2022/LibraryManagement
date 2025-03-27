package commands;

import java.util.*;

public interface ICommand {
    void execute(List<String> tokens);

    boolean isInputValid(List<String> tokens);

}
