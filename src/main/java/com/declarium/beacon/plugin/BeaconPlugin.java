package com.declarium.beacon.plugin;

import java.nio.file.Files;
import java.nio.file.Path;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * An abstraction of a {@link JavaPlugin} providing
 * additional functionality and shortcut methods.
 *
 * @author Jay Carr
 * @version 1.0
 */
public abstract class BeaconPlugin extends JavaPlugin implements Plugin {

    /**
     * Whether the default config is required for the plugin
     * and should be loaded upon the plugin enabling.
     */
    private final boolean defaultConfig;

    /**
     * Creates a new {@link BeaconPlugin} with the given
     * parameters.
     *
     * @param defaultConfig whether the default config
     *                      should be loaded
     */
    public BeaconPlugin(boolean defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    /**
     * Creates a new {@link BeaconPlugin} with default
     * parameters, whereby the creation of the default
     * config is false.
     */
    public BeaconPlugin() {
        this(false);
    }

    /**
     * Called when the plugin is loaded, but before it
     * has been enabled.
     */
    public void load() {}

    /**
     * Called when the plugin enables.
     */
    public void enable() {}

    /**
     * Called when the plugin disables.
     */
    public void disable() {}

    @Override
    public final void onLoad() {
        this.load();
    }

    @Override
    public final void onEnable() {
        if (this.defaultConfig) {
            this.saveDefaultConfig();
        }

        this.enable();
    }

    @Override
    public final void onDisable() {
        this.disable();
    }

    @Override
    public final <T extends Listener> void registerListener(T listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public final boolean isPluginEnabled(String plugin) {
        return this.getServer().getPluginManager().isPluginEnabled(plugin);
    }

    @Override
    public final YamlConfiguration loadConfiguration(String name) {
        if (!name.endsWith(".yml")) {
            name += ".yml";
        }

        Path path = this.getDataFolder().toPath().resolve(name);

        if (!Files.exists(path)) {
            this.saveResource(name, false);
        }

        return YamlConfiguration.loadConfiguration(path.toFile());
    }
}