package me.HikeKlatki;

import me.HikeKlatki.customEvents.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("aklatki").setExecutor(new turningEventOn());
        getCommand("klatki").setExecutor(new joinklatki());
       getCommand("klatki").setTabCompleter(new tabCompletion());
       getCommand("aklatki").setTabCompleter(new tabCompleterA());
        Bukkit.getPluginManager().registerEvents(new serverLeave(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
