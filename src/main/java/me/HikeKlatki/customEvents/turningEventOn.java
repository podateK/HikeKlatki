package me.HikeKlatki.customEvents;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class turningEventOn implements CommandExecutor {

    public static boolean KlatkiOn = false;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
        LuckPerms api = LuckPermsProvider.get();
        String prefix = user.getCachedData().getMetaData().getPrefix();
        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("wlacz")) {
                if(!KlatkiOn) {
                    if(sender.hasPermission("hike.klatki.admin")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8» &7Administrator&f " +  prefix + player.getName() + " wlaczyl mozliwosc brania udzialu w evencie klatik!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8» &7Aby dołaczyć, wpisz &a/klatki dolacz"));
                        KlatkiOn = true;
                    } else {
                        sender.sendMessage(ChatColor.RED + "Nie masz permisji do uzywacia tej komendy!");
                    }
                } else {
                    sender.sendMessage("§cklatki sa juz wlaczone");
                }
            } else if(args[0].equalsIgnoreCase("wylacz")) {
                if(sender.hasPermission("hikemc.klatki.admin")) {
                    if (KlatkiOn) {
                        KlatkiOn = false;
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8» &7Administrator&f " + prefix + player.getName() + " wylaczyl mozliwosc brania udzialu w evencie klatik!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8» &7Po wiecej informacji zapraszamy na naszego discorda! https://discord.gg/75Xx2rQ44h"));
                    } else {
                        sender.sendMessage("§cKlatki sa juz wylaczone!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Nie masz permisji do uzywacia tej komendy!");
                }

            }
         }

        return false;
    }
}
