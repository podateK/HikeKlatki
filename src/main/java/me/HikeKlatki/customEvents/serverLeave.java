package me.HikeKlatki.customEvents;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class serverLeave implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if(joinklatki.players.contains(player)) {
            User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
            LuckPerms api = LuckPermsProvider.get();
            String prefix = user.getCachedData().getMetaData().getPrefix();
            joinklatki.players.remove(player);
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"§8» §7Gracz §f" + prefix + player.getName() + " §7opuścił serwer, oraz wyszedł z eventu!" ));
        }


    }
}
