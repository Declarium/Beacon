package com.declarium.beacon.command.impl;

import com.declarium.beacon.command.CommandContext;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * A default implementation of {@link CommandContext}.
 *
 * @author Jay Carr
 * @version 1.0
 */
public final class DefaultCommandContext implements CommandContext {

    private final CommandSender sender;
    private final String[] args;
    private final String label;

    private DefaultCommandContext(CommandSender sender, String[] args, String label) {
        this.sender = sender;
        this.args = args;
        this.label = label;
    }

    @Override
    public CommandSender getSender() {
        return this.sender;
    }

    @Override
    public Player getPlayer() {
        if (this.sender instanceof Player) {
            return (Player) sender;
        }
        return null;
    }

    @Override
    public String[] getArgs() {
        return this.args;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}