package me.simba.admingui.fungui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class maul {
    public static void maul(Player player, String[] args) {
        if (args.length == 1){
            for (Player target : Bukkit.getOnlinePlayers()) {
                Location location = target.getLocation();
                if (args[0].equals(target.getName())){
                    target.setGameMode(GameMode.SURVIVAL);
                    target.getWorld().spawnEntity(location, EntityType.HUSK);
                    target.getWorld().spawnEntity(location, EntityType.HUSK);
                    target.getWorld().spawnEntity(location, EntityType.HUSK);
                    target.getWorld().spawnEntity(location, EntityType.HUSK);
                    target.getWorld().spawnEntity(location, EntityType.HUSK);
                    player.sendMessage(ChatColor.BLACK + "Success");

                }
            }
        }


    }

}
