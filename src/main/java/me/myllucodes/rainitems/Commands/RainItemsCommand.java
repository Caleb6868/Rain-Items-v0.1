package me.myllucodes.rainitems.Commands;

import me.myllucodes.rainitems.RainItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RainItemsCommand implements CommandExecutor {

    final private RainItems plugin;

    public RainItemsCommand(RainItems plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof  Player p) {

            final World world = p.getWorld();
            String arg = strings[0];
            try {
                if (arg.equalsIgnoreCase("on")) {
                    System.out.println("has ran");
                    p.sendMessage(ChatColor.GREEN + "It is now raining items!");
                    world.setStorm(true);

                    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
                        for (Player p1 : world.getPlayers()) {

                            world.dropItemNaturally(p1.getLocation().add((randomDistance(20) + 1) - 10, 20, (randomDistance(20) + 1) - 10), new ItemStack(randMaterial()));

                        }
                    }, 5, 5);


                } else if (arg.equalsIgnoreCase("off")) {
                    System.out.println("hasn't ran");
                    p.sendMessage(ChatColor.RED + "Item rain has been turned off");
                    world.setStorm(false);
                    Bukkit.getScheduler().cancelTasks(plugin);

                } else {
                    p.sendMessage(ChatColor.RED + "Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
        return true;
    }
    public Material randMaterial() {
        Random rand = new Random();
        Material mat = Material.values()[rand.nextInt(Material.values().length)];
        return mat;
    }
    public int randomDistance(int radii) {
        Random rand = new Random();
        int randRadii = rand.nextInt(radii);
        return randRadii;
    }
}