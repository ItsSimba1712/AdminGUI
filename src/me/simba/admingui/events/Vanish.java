package me.simba.admingui.events;

import me.simba.admingui.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Vanish implements Listener {
    Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onplayerjoin(PlayerJoinEvent event){
         Player player = event.getPlayer();


        for(Player online : Bukkit.getOnlinePlayers()){
            if(online.hasMetadata("Vanished")){
                player.hidePlayer(plugin, online);
            }
        }
    }
}
