package com.declarium.beacon.util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.bukkit.ChatColor;

public final class ChatUtil {

    private static final Pattern IP_PATTERN = Pattern.compile("^((0|1\\\\d?\\\\d?|2[0-4]?\\\\d?|" +
            "25[0-5]?|[3-9]\\\\d?)\\\\.){3}(0|1\\\\d?\\\\d?|2[0-4]?\\\\d?|25[0-5]?|[3-9]\\\\d?)$");

    private ChatUtil() {
        throw new AssertionError("Cannot instantiate this class.");
    }

    public static String useColor(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public static List<String> useColor(List<String> input) {
        return input.stream()
                .map(ChatUtil::useColor)
                .collect(Collectors.toList());
    }
}