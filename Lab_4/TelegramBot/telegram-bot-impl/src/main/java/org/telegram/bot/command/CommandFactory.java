package org.telegram.bot.command;

import org.telegram.bot.command.impl.TerminateCommand;
import org.telegram.bot.command.impl.YoutubeSearchCommand;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 20.12.2015.
 */
public class CommandFactory {

    static {
        Map<String,Command> map = new HashMap<String,Command>();
        map.put("/y", new YoutubeSearchCommand());
        map.put("/you", new YoutubeSearchCommand());
        map.put("/youtube", new YoutubeSearchCommand());
        map.put("/quit", new TerminateCommand());
        commands = Collections.unmodifiableMap(map);
    }
    private static Map<String,Command> commands;


    public static Command getCommand(String command) {
        return commands.get(command);
    }
}
