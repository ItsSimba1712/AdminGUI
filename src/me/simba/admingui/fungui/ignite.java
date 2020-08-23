package me.simba.admingui.fungui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;

public class ignite {
    public static void ignite(Player player, String[] args) {

        if (args.length == 1) {
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (args[0].equals(target.getName())) {
                    target.setFireTicks(100);
                    player.sendMessage(GREEN + "You have set " + target.getName() + " on fire!");
                }
            }
        } else if (args.length == 2) {
            int seconds = Integer.parseInt(args[1]);
            int ticks = seconds * 20;
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (args[0].equals(target.getName())) {

                    target.setFireTicks(ticks);
                    player.sendMessage(GREEN + "You have set " + target.getName() + " on fire!");

                }
            }

        } else {
            player.sendMessage(RED + "Insufficient arguments!");
            player.sendMessage(RED + "/ignite <PLAYER> <SECONDS>");
        }

    }
}
