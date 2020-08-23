package me.simba.admingui.commandsgui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class healcommand {

    public static void heal(Inventory inv, int i) {

        //       ChatColors
        String bold = ChatColor.BOLD + "";
        String darkgray = ChatColor.DARK_GRAY + "";
        String gold = ChatColor.GOLD + "";


        ItemStack heal = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta heal_meta = heal.getItemMeta();
        heal_meta.setDisplayName(gold + bold + "Heal");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(darkgray + "Heals the player");
        heal_meta.setLore(lore);
        heal.setItemMeta(heal_meta);

        inv.setItem(i, heal);

    }

    public static void healcommand(Player ply) {
        if (ply.getHealth() < 20) {
            ply.setHealth(20);
            ply.sendMessage(ChatColor.GREEN + "You have been healed!");
        } else {
            ply.sendMessage(ChatColor.RED + "You are already full health.");
        }
    }

}
