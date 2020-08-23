package me.simba.admingui;

import me.simba.admingui.commands.gui;
import me.simba.admingui.events.*;
import me.simba.admingui.events.FunClick;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        System.out.println(ChatColor.GREEN + "\n\nAdminGUI has been Enabled!\n\n");
        getCommand("gui").setExecutor(new gui());
        getCommand("feed").setExecutor(new gui());
        getCommand("vanish").setExecutor(new gui());
        getCommand("heal").setExecutor(new gui());
        getCommand("fly").setExecutor(new gui());
        getCommand("ignite").setExecutor(new gui());
        getCommand("blind").setExecutor(new gui());
        getCommand("maul").setExecutor(new gui());
        getServer().getPluginManager().registerEvents(new AdminGUIClick(), this);
        getServer().getPluginManager().registerEvents(new GamemodesClick(), this);
        getServer().getPluginManager().registerEvents(new CommandClick(), this);
        getServer().getPluginManager().registerEvents(new Vanish(), this);
        getServer().getPluginManager().registerEvents(new FunClick(), this);
    }
    public void onDisable(){
        System.out.println(ChatColor.RED + "\n\nAdminGUI has been Disabled!\n\n");
    }
}
