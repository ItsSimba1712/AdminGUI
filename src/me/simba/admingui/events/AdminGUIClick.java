package me.simba.admingui.events;

import me.simba.admingui.commandsgui.fly;
import me.simba.admingui.commandsgui.foodcommand;
import me.simba.admingui.commandsgui.healcommand;
import me.simba.admingui.commandsgui.vanish;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.ChatColor.*;

public class AdminGUIClick implements Listener {
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

    private void creative(Inventory inv, int i) {

        // Creates the item and sets meta data
        ItemStack creative = new ItemStack(Material.BEDROCK);
        ItemMeta creative_meta = creative.getItemMeta();
        creative_meta.setDisplayName(gray + "Creative");
        ArrayList<String> creative_lore = new ArrayList<String>();
        creative_lore.add(darkred + "Sets your gamemode to creative");
        creative_meta.setLore(creative_lore);
        creative.setItemMeta(creative_meta);

        inv.setItem(i, creative);
    }

    private void survival(Inventory inv, int i) {

        // Creates the item and sets meta data
        ItemStack survival = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta survival_meta = survival.getItemMeta();
        survival_meta.setDisplayName(white + "Survival");
        ArrayList<String> survival_lore = new ArrayList<String>();
        survival_lore.add(aqua + "Sets your gamemode to survival");
        survival_meta.setLore(survival_lore);
        survival.setItemMeta(survival_meta);

        inv.setItem(i, survival);
    }

    private void adventure(Inventory inv, int i) {

        // Creates the item and sets meta data
        ItemStack adventure = new ItemStack(Material.DIRT);
        ItemMeta adventure_meta = adventure.getItemMeta();
        adventure_meta.setDisplayName(gold + "Adventure");
        ArrayList<String> adventure_lore = new ArrayList<String>();
        adventure_lore.add(lightpurple + "Sets your gamemode to adventure");
        adventure_meta.setLore(adventure_lore);
        adventure.setItemMeta(adventure_meta);

        inv.setItem(i, adventure);
    }

    private void spectator(Inventory inv, int i) {

        // Creates the item and sets meta data
        ItemStack spectator = new ItemStack(Material.GLASS);
        ItemMeta spectator_meta = spectator.getItemMeta();
        spectator_meta.setDisplayName(yellow + "Spectator");
        ArrayList<String> spectator_lore = new ArrayList<String>();
        spectator_lore.add(darkaqua + "Sets your gamemode to spectator");
        spectator_meta.setLore(spectator_lore);
        spectator.setItemMeta(spectator_meta);

        inv.setItem(i, spectator);
    }

    private void maul(Inventory inv, int i) {
        ItemStack maul = new ItemStack(Material.ZOMBIE_SPAWN_EGG);
        ItemMeta maul_meta = maul.getItemMeta();
        maul_meta.setDisplayName(red + bold + "Maul");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(white + "Spawns a bunch of zombies");
        lore.add(white + "at the target player!");
        maul_meta.setLore(lore);
        maul.setItemMeta(maul_meta);

        inv.setItem(i, maul);

    }

    private void ignite(Inventory inv, int i) {
        ItemStack ignite = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta ignite_meta = ignite.getItemMeta();
        ignite_meta.setDisplayName(RED + bold + "Ignite");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(white + "Sets the target player on fire!");
        ignite_meta.setLore(lore);
        ignite.setItemMeta(ignite_meta);

        inv.setItem(i, ignite);

    }

    private void blind(Inventory inv, int i) {
        ItemStack blind = new ItemStack(Material.INK_SAC);
        ItemMeta blind_meta = blind.getItemMeta();
        blind_meta.setDisplayName(gray + bold + "Blind");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(white + "Blinds the target player!");
        blind_meta.setLore(lore);
        blind.setItemMeta(blind_meta);

        inv.setItem(i, blind);

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if (event.getCurrentItem() == null || event.getCurrentItem().getType().equals(Material.AIR)) {
            return;
        }

        Material mat = event.getCurrentItem().getType();
        HumanEntity ply = event.getWhoClicked();
        ItemMeta mat_meta = event.getCurrentItem().getItemMeta();

        if (event.getView().getTitle().equals(black + "" + bold + "AdminGUI")) {
            event.setCancelled(true);

            if (mat.equals(Material.CRAFTING_TABLE) && mat_meta.getDisplayName().equals(gold + "Gamemodes")) {

                Inventory gui = Bukkit.createInventory(null, 9, darkgreen + bold + "Gamemodes");

                creative(gui, 0);
                survival(gui, 1);
                adventure(gui, 2);
                spectator(gui, 3);

                ply.openInventory(gui);
            } else if (mat.equals(Material.FLINT_AND_STEEL) && mat_meta.getDisplayName().equals(white + "Commands")) {

                Inventory gui = Bukkit.createInventory(null, 9, darkaqua + bold + "Commands");

                foodcommand.food(gui, 0);
                vanish.vanish(gui, 1);
                healcommand.heal(gui, 2);
                fly.fly(gui, 3);

                ply.openInventory(gui);
            } else if (mat.equals(Material.CHORUS_FRUIT) && mat_meta.getDisplayName().equals(red + "Fun")) {

                Inventory gui = Bukkit.createInventory(null, 9, darkpurple + bold + "Fun");

                maul(gui, 0);
                ignite(gui, 1);
                blind(gui, 2);

                ply.openInventory(gui);
            }
        }
    }
}
