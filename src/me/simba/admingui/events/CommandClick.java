package me.simba.admingui.events;

import me.simba.admingui.Main;
import me.simba.admingui.commandsgui.fly;
import me.simba.admingui.commandsgui.foodcommand;
import me.simba.admingui.commandsgui.healcommand;
import me.simba.admingui.commandsgui.vanish;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class CommandClick implements Listener {

    //       ChatColors
    String bold = ChatColor.BOLD + "";
    String white = ChatColor.WHITE + "";
    String darkpurple = ChatColor.DARK_PURPLE + "";
    String green = ChatColor.GREEN + "";
    String red = ChatColor.RED + "";
    String yellow = ChatColor.YELLOW + "";
    String black = ChatColor.BLACK + "";
    String darkgray = ChatColor.DARK_GRAY + "";
    String aqua = ChatColor.AQUA + "";
    String darkaqua = ChatColor.DARK_AQUA + "";
    String gold = ChatColor.GOLD + "";
    String gray = ChatColor.GRAY + "";
    String italic = ChatColor.ITALIC + "";
    String lightpurple = ChatColor.LIGHT_PURPLE + "";
    String magic = ChatColor.MAGIC + "";
    String reset = ChatColor.RESET + "";
    String strikethrough = ChatColor.STRIKETHROUGH + "";
    String underline = ChatColor.UNDERLINE + "";
    String darkred = ChatColor.DARK_RED + "";
    String darkgreen = ChatColor.DARK_GREEN + "";
    String darkblue = ChatColor.DARK_BLUE + "";
    String blue = ChatColor.BLUE + "";

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Plugin plugin = Main.getPlugin(Main.class);


        if (event.getCurrentItem()==null || event.getCurrentItem().getType().equals(Material.AIR)){
            return;
        }
        Player ply = (Player) event.getWhoClicked();
        ItemStack mat = event.getCurrentItem();

        if (event.getView().getTitle().equals(darkaqua + bold + "Commands")) {
            event.setCancelled(true);

            if(mat.getType() == Material.COOKED_BEEF && mat.getItemMeta().getDisplayName().equals(gold + bold + "Feed")){
                foodcommand.foodcommand((Player) ply);
                ply.closeInventory();
            }else if(mat.getType()== Material.BLACK_CONCRETE && mat.getItemMeta().getDisplayName().equalsIgnoreCase(gray + bold + "Vanish")){
                vanish.vanish(ply, plugin);
                ply.closeInventory();
            }else if(mat.getType() == Material.GOLDEN_APPLE && mat.getItemMeta().getDisplayName().equals(gold + bold + "Heal")){
                healcommand.healcommand((Player) ply);
                ply.closeInventory();
            }else if(mat.getType() == Material.FEATHER && mat.getItemMeta().getDisplayName().equals(white + bold + "Fly")){
                fly.fly((Player) ply);
                ply.closeInventory();
            }

        }

    }
}
