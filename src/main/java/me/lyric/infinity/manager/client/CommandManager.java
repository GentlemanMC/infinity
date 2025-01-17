package me.lyric.infinity.manager.client;

import me.lyric.infinity.api.command.Command;
import me.lyric.infinity.impl.commands.ConfigCommand;
import me.lyric.infinity.impl.commands.FriendCommand;
import me.lyric.infinity.impl.commands.PrefixCommand;
import me.lyric.infinity.impl.commands.ToggleCommand;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lyric - forced to use clientMessage here
 */

public class CommandManager {

    private static CommandManager commandManager;
    private String clientMessage = "[Infinity]";

    private final Set<Command> commands = new HashSet<>();

    private String prefix = "-";

    public static CommandManager getCommandManager() {
        return commandManager;
    }

    public static Command get(final String commandStr) {
        Command command = null;

        for (Command commands : commandManager.getCommands()) {
            if (commands.getCommand().equalsIgnoreCase(commandStr)) {
                command = commands;

                break;
            }
        }

        return command;
    }

    public void init() {
        this.commands.add(new PrefixCommand());
        this.commands.add(new ConfigCommand());
        this.commands.add(new FriendCommand());
        this.commands.add(new ToggleCommand());
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Set<Command> getCommands() {
        return commands;
    }

    public String getClientMessage() {
        return this.clientMessage;
    }

    public void setClientMessage(String clientMessage) {
        this.clientMessage = clientMessage;
    }
}
