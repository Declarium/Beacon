package com.declarium.beacon.plugin;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

/**
 * Represents a plugin that runs as an addon to the
 * Bukkit server.
 *
 * @author Jay Carr
 * @version 1.0
 */
public interface Plugin {

    /**
     * A shortcut method to register a {@link Listener} with
     * the server.
     *
     * @param listener the listener to register
     */
    <T extends Listener> void registerListener(T listener);

    /**
     * A shortcut method to check whether a plugin is enabled
     * on the server.
     *
     * @param plugin the plugin name
     */
    boolean isPluginEnabled(String plugin);

    /**
     * Loads a {@link YamlConfiguration} with the given name,
     * creating the file from the embedded resource if it is
     * not found in the plugin's data folder.
     *
     * <p>The file name should end in .yml, if not, this will
     * be appended before the configuration is loaded./p>
     *
     * @param name the file name
     * @return the loaded configuration
     */
    YamlConfiguration loadConfiguration(String name);
}