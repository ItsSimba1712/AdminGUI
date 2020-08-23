package me.simba.admingui.commandsgui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

import static org.bukkit.ChatColor.GREEN;

public class vanish {

    public static void vanish(Inventory inv, int i) {

        //       ChatColors
        String bold = ChatColor.BOLD + "";
        String white = ChatColor.WHITE + "";
        String gray = ChatColor.GRAY + "";


        ItemStack vanish = new ItemStack(Material.BLACK_CONCRETE);
        ItemMeta vanish_meta = vanish.getItemMeta();
        vanish_meta.setDisplayName(gray + bold + "Vanish");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(white + "Makes the player disappear");
        vanish_meta.setLore(lore);
        vanish.setItemMeta(vanish_meta);

        inv.setItem(i, vanish);
    }

    public static void vanish(Player ply, Plugin plugin) {
        if (!ply.hasMetadata("Vanished")) {
            ply.setMetadata("Vanished", new FixedMetadataValue(plugin, true));
            ply.sendMessage(GREEN + "Ninja Vanish!");
            for (Player online : Bukkit.getOnlinePlayers()) {
                online.hidePlayer(plugin, ply);
            }
        } else {
            ply.removeMetadata("Vanished", plugin);
            ply.sendMessage(GREEN + "You are visible!");
            for (Player online : Bukkit.getOnlinePlayers()) {
                online.showPlayer(plugin, ply);
            }
        }
    }

}
