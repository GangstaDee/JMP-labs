package command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 20.12.2015.
 */
public class CommandFactory {

    private final static Map<String,Command> commands = new HashMap<>();

    public static Command addCommand(String action, Command command) {

        return commands.put(action,command);
    }

    public final static Command getCommand(String action) {

        try {
            return commands.containsKey(action) ? commands.get(action).clone() : null;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
