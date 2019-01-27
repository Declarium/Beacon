package com.declarium.beacon.util;

import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.ChatColor;

/**
 * Utilities to simplify the color formatting of
 * messages via {@link ChatColor}.
 *
 * @author Jay Carr
 * @version 1.0
 */
public final class ColorUtil {

    private ColorUtil() {
        throw new AssertionError("Cannot instantiate this class.");
    }

    public static String useColor(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public static List<String> useColor(List<String> input) {
        return input.stream()
                .map(ColorUtil::useColor)
                .collect(Collectors.toList());
    }
}