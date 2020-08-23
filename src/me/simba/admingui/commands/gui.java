package me.simba.admingui.commands;

import me.simba.admingui.Main;
import me.simba.admingui.commandsgui.fly;
import me.simba.admingui.commandsgui.foodcommand;
import me.simba.admingui.commandsgui.healcommand;
import me.simba.admingui.commandsgui.vanish;
import me.simba.admingui.fungui.blind;
import me.simba.admingui.fungui.ignite;
import me.simba.admingui.fungui.maul;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

import static org.bukkit.ChatColor.*;

public class gui implements CommandExecutor {
    Plugin plugin = Main.getPlugin(Main.class);

    private void gamemodes(Inventory inv, int i) {

        //       ChatColors
        String darkpurple = DARK_PURPLE + "";
        String gold = GOLD + "";

        // Creates the item and sets meta data
        ItemStack gamemodes = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta gamemodes_meta = gamemodes.getItemMeta();
        gamemodes_meta.setDisplayName(gold + "Gamemodes");
        ArrayList<String> gamemodes_lore = new ArrayList<>();
        gamemodes_lore.add(darkpurple + "Change your form!");
        gamemodes_meta.setLore(gamemodes_lore);
        gamemodes.setItemMeta(gamemodes_meta);

        inv.setItem(i, gamemodes);

    }

    private void partytime(Inventory inv, int i) {

        //       ChatColors
        String red = RED + "";
        String blue = BLUE + "";

        // Creates the item and sets meta data
        ItemStack partytime = new ItemStack(Material.CHORUS_FRUIT);
        ItemMeta partytime_meta = partytime.getItemMeta();
        partytime_meta.setDisplayName(red + "Fun");
        ArrayList<String> partytime_lore = new ArrayList<>();
        partytime_lore.add(blue + "Party Time!");
        partytime_meta.setLore(partytime_lore);
        partytime.setItemMeta(partytime_meta);

        inv.setItem(i, partytime);

    }

    private void admin(Inventory inv, int i) {

        //       ChatColors
        String darkaqua = DARK_AQUA + "";
        String darkgreen = DARK_GREEN + "";

        // Creates the item and sets meta data
        ItemStack admin = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta admin_meta = admin.getItemMeta();
        admin_meta.setDisplayName(darkgreen + "Admin");
        ArrayList<String> admin_lore = new ArrayList<String>();
        admin_lore.add(darkaqua + "Unleash your power!");
        admin_meta.setLore(admin_lore);
        admin.setItemMeta(admin_meta);

        inv.setItem(i, admin);
    }

    private void commands(Inventory inv, int i) {

        //       ChatColors
        String white = WHITE + "";
        String lightpurple = LIGHT_PURPLE + "";

        // Creates the item and sets meta data
        ItemStack commands = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta commands_meta = commands.getItemMeta();
        commands_meta.setDisplayName(white + "Commands");
        ArrayList<String> commands_lore = new ArrayList<>();
        commands_lore.add(lightpurple + "Test your power!");
        commands_meta.setLore(commands_lore);
        commands.setItemMeta(commands_meta);

        inv.setItem(i, commands);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        //       ChatColors
        String bold = BOLD + "";
        String black = BLACK + "";

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("gui")) {

                Inventory gui = Bukkit.createInventory(null, 9, black + bold + "AdminGUI");

                gamemodes(gui, 0);
                partytime(gui, 1);
                admin(gui, 2);
                commands(gui, 3);

                player.openInventory(gui);
                return true;

            } else if (cmd.getName().equalsIgnoreCase("feed")) {
                foodcommand.foodcommand(player);
                return true;
            } else if (cmd.getName().equalsIgnoreCase("vanish")) {
                vanish.vanish(player, plugin);
                return true;
            } else if (cmd.getName().equalsIgnoreCase("heal")) {
                healcommand.healcommand(player);
                return true;
            } else if (cmd.getName().equalsIgnoreCase("fly")) {
                fly.fly(player);
                return true;
            } else if (cmd.getName().equalsIgnoreCase("ignite")) {
                ignite.ignite(player, args);
               return true;
            }else if (cmd.getName().equalsIgnoreCase("blind")){
                blind.blind(player, args);
                return true;
            } else if (cmd.getName().equalsIgnoreCase("maul")){
                maul.maul(player, args);
                return true;
            }

        } else {
            sender.sendMessage(RED + "You have to be a player to use this command!");
            return true;
        }

        return false;
    }
}

