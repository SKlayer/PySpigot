package dev.magicmq.pyspigot.config;

import dev.magicmq.pyspigot.PySpigot;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class PluginConfig {

    private static FileConfiguration config;

    static {
        reload();
    }

    public static void reload() {
        config = PySpigot.get().getConfig();
    }

    public static long getLoadScriptDelay() {
        return config.getLong("script-load-delay", 20L);
    }

    public static boolean autorunScriptsEnabled() {
        return config.getBoolean("autorun-scripts-enabled", true);
    }

    public static List<String> getAutorunScripts() {
        return config.getStringList("autorun-scripts");
    }

    public static String getMessage(String key, boolean withPrefix) {
        return ChatColor.translateAlternateColorCodes('&', (withPrefix ? config.getString("messages.plugin-prefix") : "") + config.getString("messages." + key));
    }
}