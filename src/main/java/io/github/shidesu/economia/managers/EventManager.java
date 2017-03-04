package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class EventManager implements Listener {

    private PlayerAccountManager playerAccountManager;
    private Economia eco;
    private PluginManager pm;
    private Listener l;

    public EventManager(Economia eco) {
       /* PluginManager pm = p.getServer().getPluginManager();
        pm.registerEvents(this, p);*/
        this.eco = eco;
        this.pm = eco.getServer().getPluginManager();
        this.playerAccountManager = eco.getPlayerAccountManager();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PlayerManager joiningPlayer = new PlayerManager(p);

        if (!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage("Le nouveau venu va avoir son compte en banque olallalala !");
            playerAccountManager.createAccount(joiningPlayer);


        } else {
            Bukkit.broadcastMessage("Celui là a déjà un compte en banque olalalalla !");
            playerAccountManager.getAccount(joiningPlayer);
        }
    }

    public Listener getL() {
        return this.l;
    }

    public PluginManager getPm() {
        return this.pm;
    }

    public PlayerAccountManager getPlayerAccountManager() {
        return this.playerAccountManager;
    }
}
