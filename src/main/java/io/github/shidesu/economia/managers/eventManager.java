package io.github.shidesu.economia.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class eventManager implements Listener {
    public eventManager(Plugin p) {
       /* PluginManager pm = p.getServer().getPluginManager();
        pm.registerEvents(this, p);*/
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage("Le nouveau venu va avoir son compte en banque olallalala !");

        }
        else{
            Bukkit.broadcastMessage("Celui là a déjà un compte en banque olalalalla !");
        }
    }
}
