package me.HikeKlatki.customEvents;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender; // KYS
import org.bukkit.entity.Player; // KYS
import org.bukkit.event.EventHandler; // NA CHUJ NA TO PATRZYSZ
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull; // ZJEBIE

import java.util.ArrayList;

public class joinklatki implements CommandExecutor {

    public static boolean KlatkiOn = false;

    public static ArrayList<Player> players = new ArrayList<>();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
        LuckPerms api = LuckPermsProvider.get();
        String prefix = user.getCachedData().getMetaData().getPrefix();
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("dolacz")) {
                if (turningEventOn.KlatkiOn) {
                    if(!players.contains(player)) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8»&f " + prefix + player.getName() + " dołaczył do eventu klatki!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8» &7Aby dołaczyć, wpisz &a/klatki dolacz"));
                        World swiatGracza = ((Player) sender).getWorld();
                        player.getInventory().clear();
                        Location location1 = new Location(swiatGracza, 55, 90, -435);
                        player.teleport(location1);
                        players.add(player);
                        // kordy widowni na klatkach 54 90 -433
                    } else {
                        sender.sendMessage("§cDolaczyles juz na event klatki!");
                    }
                } else {
                    sender.sendMessage("§cNie mozesz dolaczyc do eventu klatki, poniewaz jest on wylaczony");
                }
            } else if (args[0].equalsIgnoreCase("opusc")) {
                // kordy spawnu
                // 58 -241
                if (turningEventOn.KlatkiOn) {
                    if(players.contains(player)) {
                        players.remove(player);
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8» &f " + prefix + player.getName() + " opuścił event klatki!"));
                        World swiatGracza = ((Player) sender).getWorld();
                        Location location2 = new Location(swiatGracza, 126, 58, -241);
                        player.teleport(location2);
                        sender.sendMessage("§cJesteś gejem bo leavujesz!");
                    } else {
                        player.sendMessage("§cNie możesz opuścić eventu, na którym już jesteś!");
                    }

                } else {
                    sender.sendMessage("§cKlatki sa wylaczone!");
                }

            }
        }
    return false;
    }
    }
