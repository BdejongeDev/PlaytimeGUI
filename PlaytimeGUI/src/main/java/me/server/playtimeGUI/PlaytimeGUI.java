package me.server.playtimeGUI;

import me.server.playtimeGUI.commands.PlaytimeCommand;
import me.server.playtimeGUI.listeners.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public class PlaytimeGUI extends JavaPlugin {

    private static PlaytimeGUI instance;

    @Override
    public void onEnable() {

        instance = this;

        getCommand("playtime").setExecutor(new PlaytimeCommand());

        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        getLogger().info("PlaytimeGUI enabled.");
        getLogger().info("PlaytimeGUI Made by BDejonge") 
        getLogger().info("Join my discord now https://discord.gg/stXA8G69g2")
    }

    public static PlaytimeGUI getInstance() {
        return instance;
    }
}
