package me.simba.admingui.fungui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.ChatColor.RED;

public class blind {
    public static void blind(Player player, String[] args) {
        if (args.length == 1) {
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (args[0].equals(target.getName())) {
                    target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1000000, 255));
                    player.sendMessage(ChatColor.GREEN + "You have blinded " + target.getName() + "!");
                }
            }
        } else if (args.length == 2) {
            int seconds = Integer.parseInt(args[1]);
            int ticks = seconds * 20;
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (args[0].equals(target.getName())) {

                    target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, ticks, 255));
                    player.sendMessage(ChatColor.GREEN + "You have blinded " + target.getName() + "!");
                }
            }
        } else {
            player.sendMessage(RED + "Insufficient arguments!");
            player.sendMessage(RED + "/blind <PLAYER> <SECONDS>");
        }

    }

}
