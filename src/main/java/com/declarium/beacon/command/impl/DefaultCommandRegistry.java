package com.declarium.beacon.command.impl;

import com.declarium.beacon.command.Command;
import com.declarium.beacon.command.CommandContext;
import com.declarium.beacon.command.CommandRegistry;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A default implementation of {@link CommandRegistry}.
 *
 * @author Jay Carr
 * @version 1.0
 */
public final class DefaultCommandRegistry implements CommandRegistry, CommandExecutor {

    private final Map<String, Map.Entry<Command, Method>> commands = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override
    public void register(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            Command command = method.getAnnotation(Command.class);
            if (command == null) {
                continue;
            }

            Class<?>[] parameters = method.getParameterTypes();
            if (parameters.length != 1 || !parameters[0].isAssignableFrom(CommandContext.class)) {
                continue;
            }

            Bukkit.getServer().getPluginCommand(command.name()).setExecutor(this);
            this.commands.put(command.name(), new AbstractMap.SimpleEntry<>(command, method));
        }
    }

    @Override
    public boolean execute(CommandSender sender, org.bukkit.command.Command command, String name, String[] args) {
        Map.Entry<Command, Method> entry = this.commands.get(name);

        // Command does not have a handling method within this command executor
        if (entry == null) {
            return false;
        }

        // TODO - arg check, command usage, etc.

        try {
            CommandContext context = new DefaultCommandContext(sender, args, name);
            entry.getValue().invoke(context);
            return true;
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO - exception handling
        }

        return false;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        return this.execute(sender, cmd, label, args);
    }
}