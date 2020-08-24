package me.simba.admingui.events;

import me.simba.admingui.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

import static org.bukkit.ChatColor.GOLD;

public class FunClick implements Listener {
    Plugin plugin = Main.getPlugin(Main.class);
    @SuppressWarnings("deprication")

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

    public static void getPlayerHeads(Player ply, Inventory inv) {

        ArrayList<Player> player_list = new ArrayList<>(ply.getServer().getOnlinePlayers());
        int i = 0;
        for (Player player : player_list) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();
            SkullMeta skull_meta = (SkullMeta) playerHead.getItemMeta();
            skull_meta.setOwner(player.getName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(GOLD + "Player Health: " + player.getHealth());
            playerHead.setItemMeta(skull_meta);
            meta.setDisplayName(player.getDisplayName());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            inv.setItem(i, playerHead);
            i++;
        }

    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        String inv_view = event.getView().getTitle();

        if (event.getCurrentItem() == null || event.getCurrentItem().getType().equals(Material.AIR)) {
            return;
        }
        ItemStack mat = event.getCurrentItem();
        ItemMeta mat_meta = mat.getItemMeta();

        if (inv_view.equals(darkpurple + bold + "Fun")) {
            event.setCancelled(true);

            if (mat.getType() == Material.FLINT_AND_STEEL && mat_meta.getDisplayName().equals(red + bold + "Ignite")) {

                Inventory inv = Bukkit.createInventory(null, 45, red + bold + "Ignite");

                getPlayerHeads(player, inv);

                player.openInventory(inv);

            } else if (mat.getType() == Material.INK_SAC && mat_meta.getDisplayName().equals(gray + bold + "Blind")) {

                Inventory inv = Bukkit.createInventory(null, 45, black + bold + "Blind");

                getPlayerHeads(player, inv);

                player.openInventory(inv);

            } else if (mat.getType() == Material.ZOMBIE_SPAWN_EGG && mat_meta.getDisplayName().equals(red + bold + "Maul")) {

                Inventory inv = Bukkit.createInventory(null, 45, red + bold + "Maul");

                getPlayerHeads(player, inv);

                player.openInventory(inv);
            }

        } else if (inv_view.equals(black + bold + "Blind")) {
            event.setCancelled(true);

            if (mat.getType().equals(Material.PLAYER_HEAD)) {

                for (Player target : Bukkit.getOnlinePlayers()) {
                    if (mat_meta.getDisplayName().equals(target.getName())) {
                        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 255));
                        player.sendMessage(ChatColor.GREEN + "You have blinded " + target.getName() + "!");
                        player.closeInventory();
                    }
                }
            }

        } else if (inv_view.equals(red + bold + "Ignite")) {
            event.setCancelled(true);

            if (mat.getType().equals(Material.PLAYER_HEAD)) {

                for (Player target : Bukkit.getOnlinePlayers()) {
                    if (mat_meta.getDisplayName().equals(target.getName())) {
                        target.setFireTicks(100);
                        player.sendMessage(green + "You have set " + target.getName() + " on fire!");
                        player.closeInventory();

                    }
                }

            }

        } else if (inv_view.equals(red + bold + "Maul")) {
            event.setCancelled(true);

            if (mat.getType().equals(Material.PLAYER_HEAD)) {

                for (Player target : Bukkit.getOnlinePlayers()) {
                    Location location = target.getLocation();

                    target.setGameMode(GameMode.SURVIVAL);
                    Entity husk = Bukkit.getWorld("world").spawnEntity(location, EntityType.HUSK);
                    husk.setMetadata("maul_husk", new FixedMetadataValue(plugin, true));
                    husk = Bukkit.getWorld("world").spawnEntity(location, EntityType.HUSK);
                    husk.setMetadata("maul_husk", new FixedMetadataValue(plugin, true));
                    husk = Bukkit.getWorld("world").spawnEntity(location, EntityType.HUSK);
                    husk.setMetadata("maul_husk", new FixedMetadataValue(plugin, true));
                    husk = Bukkit.getWorld("world").spawnEntity(location, EntityType.HUSK);
                    husk.setMetadata("maul_husk", new FixedMetadataValue(plugin, true));
                    husk = Bukkit.getWorld("world").spawnEntity(location, EntityType.HUSK);
                    husk.setMetadata("maul_husk", new FixedMetadataValue(plugin, true));
                    for (LivingEntity entity : target.getWorld().getLivingEntities()) {
                        if (entity.hasMetadata("maul_husk")) {
                            entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 3));
                            entity.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 200, 100));
                            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 3));
                            entity.removeMetadata("maul_husk", plugin);
                        }
                    }
                    player.sendMessage(ChatColor.GREEN + "You have mauled " + target.getName() + "!");
                    player.closeInventory();
                }
            }

        }

    }

}
