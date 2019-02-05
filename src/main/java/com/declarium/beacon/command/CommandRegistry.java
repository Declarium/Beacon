package com.declarium.beacon.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * A registry for handling the registering and execution
 * of server commands.
 *
 * @author Jay Carr
 * @version 1.0
 */
public interface CommandRegistry {

    /**
     * Registers all methods annotated with {@link Command}
     * within the given objects' class.
     *
     * @param object the object to register commands from
     */
    void register(Object object);

    /**
     * Executes the supplied command, returning whether the
     * execution was successful or not.
     *
     * @param sender the sender of the command
     * @param command the command to execute
     * @param name the command name
     * @param args the provided command arguments
     * @return true if execution is successful, otherwise false
     */
    boolean execute(CommandSender sender, org.bukkit.command.Command command, String name, String[] args);
}