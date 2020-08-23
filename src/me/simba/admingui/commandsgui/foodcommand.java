package me.simba.admingui.commandsgui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;

public class foodcommand {

    public static void food(Inventory inv, int i) {

        //       ChatColors
        String bold = ChatColor.BOLD + "";
        String white = ChatColor.WHITE + "";
        String gold = ChatColor.GOLD + "";


        ItemStack food = new ItemStack(Material.COOKED_BEEF);
        ItemMeta food_meta = food.getItemMeta();
        food_meta.setDisplayName(gold + bold + "Feed");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(white + "Makes the player fat! ;D");
        food_meta.setLore(lore);
        food.setItemMeta(food_meta);

        inv.setItem(i, food);

    }

    public static void foodcommand(Player ply) {

        // Chat Colors
        String red = RED + "";
        String green = GREEN + "";

        if (ply.getFoodLevel() < 20) {
            ply.setFoodLevel(20);
            ply.sendMessage(green + "You have been fed!");
        } else {
            ply.sendMessage(red + "You are already full!");
        }

    }
}
