package com.declarium.beacon.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Represents the context of a command executed
 * on the server by a {@link CommandSender}.
 *
 * @author Jay Carr
 * @version 1.0
 */
public interface CommandContext {

    /**
     * Returns the sender of the command.
     *
     * @return the sender
     */
    CommandSender getSender();

    /**
     * Returns the {@link Player} that executed the
     * command.
     *
     * <p>This method may return null if the
     * sender is not a player.</p>
     *
     * @return the player
     */
    Player getPlayer();

    /**
     * Returns the arguments passed alongside the
     * command.
     *
     * @return the arguments
     */
    String[] getArgs();

    /**
     * Returns the alias of the command which
     * was used.
     *
     * @return the label used
     */
    String getLabel();
}