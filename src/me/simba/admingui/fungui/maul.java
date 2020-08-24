package me.simba.admingui.fungui;

import me.simba.admingui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.ChatColor.RED;

public class maul {
    static Plugin plugin = Main.getPlugin(Main.class);

    public static void maul(Player player, String[] args) {
        if (args.length == 1) {
            for (Player target : Bukkit.getOnlinePlayers()) {
                Location location = target.getLocation();

                if (args[0].equals(target.getName())) {
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
                }
            }
        } else {
            player.sendMessage(RED + "Insufficient arguments!");
            player.sendMessage(RED + "/maul <PLAYER>");
        }

    }

}
