package me.simba.admingui.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static org.bukkit.ChatColor.*;

public class GamemodesClick implements Listener {

    //       ChatColors
    String bold = BOLD + "";
    String white = WHITE + "";
    String darkpurple = DARK_PURPLE + "";
    String green = GREEN + "";
    String red = RED + "";
    String yellow = YELLOW + "";
    String black = BLACK + "";
    String darkgray = DARK_GRAY + "";
    String aqua = AQUA + "";
    String darkaqua = DARK_AQUA + "";
    String gold = GOLD + "";
    String gray = GRAY + "";
    String italic = ITALIC + "";
    String lightpurple = LIGHT_PURPLE + "";
    String magic = MAGIC + "";
    String reset = RESET + "";
    String strikethrough = STRIKETHROUGH + "";
    String underline = UNDERLINE + "";
    String darkred = DARK_RED + "";
    String darkgreen = DARK_GREEN + "";
    String darkblue = DARK_BLUE + "";
    String blue = BLUE + "";

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {

        if (event.getCurrentItem()==null || event.getCurrentItem().getType().equals(Material.AIR)){
            return;
        }

        if (event.getView().getTitle().equals(darkgreen + bold + "Gamemodes")) {
            event.setCancelled(true);

            HumanEntity ply = event.getWhoClicked();
            Material mat = event.getCurrentItem().getType();

            if (mat.equals(Material.BEDROCK)) {
                if (ply.getGameMode() == GameMode.CREATIVE) {
                    ply.sendMessage(red + "You are already in " + ply.getGameMode().toString().toLowerCase() + "!");
                } else {
                    ply.setGameMode(GameMode.CREATIVE);
                    ply.sendMessage(green + "Your gamemode has been set to creative!");
                }
                ply.closeInventory();

            } else if (mat.equals(Material.GRASS_BLOCK)) {
                if (ply.getGameMode() == GameMode.SURVIVAL) {
                    ply.sendMessage(red + "You are already in " + ply.getGameMode().toString().toLowerCase() + "!");
                } else {
                    ply.setGameMode(GameMode.SURVIVAL);
                    ply.sendMessage(green + "Your gamemode has been set to survival!");
                }
                ply.closeInventory();

            } else if (mat.equals(Material.DIRT)) {
                if (ply.getGameMode() == GameMode.ADVENTURE) {
                    ply.sendMessage(red + "You are already in " + ply.getGameMode().toString().toLowerCase() + "!");
                } else {
                    ply.setGameMode(GameMode.ADVENTURE);
                    ply.sendMessage(green + "Your gamemode has been set to adventure!");
                }
                ply.closeInventory();
            } else if (mat.equals(Material.GLASS)) {
                if (ply.getGameMode() == GameMode.SPECTATOR){
                    ply.sendMessage(red + "You are already in " + ply.getGameMode().toString().toLowerCase() + "!");
                } else{
                    ply.setGameMode(GameMode.SPECTATOR);
                    ply.sendMessage(green + "Your gamemode has been set to spectator");
                }
                ply.closeInventory();


            }

        }

    }
}