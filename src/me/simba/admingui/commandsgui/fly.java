package me.simba.admingui.commandsgui;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;

public class fly {

    public static void fly(Inventory inv, int i) {

        //       ChatColors
        String bold = ChatColor.BOLD + "";
        String white = ChatColor.WHITE + "";
        String blue = ChatColor.BLUE + "";

        ItemStack fly = new ItemStack(Material.FEATHER);
        ItemMeta fly_meta = fly.getItemMeta();
        fly_meta.setDisplayName(white + bold + "Fly");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(blue + "I believe I can fly!");
        fly_meta.setLore(lore);
        fly.setItemMeta(fly_meta);

        inv.setItem(i, fly);

    }
    public static void fly(Player ply) {
        if (ply.getGameMode() == GameMode.CREATIVE || ply.getGameMode() == GameMode.SPECTATOR) {
            ply.sendMessage(RED + "You are already in " + ply.getGameMode().toString().toLowerCase() + "!");

        } else {
            if (!ply.getAllowFlight()) {
                ply.setAllowFlight(true);
                ply.sendMessage(GREEN + "You can fly!");

            } else {
                ply.setAllowFlight(false);
                ply.sendMessage(GREEN + "You are no longer flying!");

            }
        }
    }
}
