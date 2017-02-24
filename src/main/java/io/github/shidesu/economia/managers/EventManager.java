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
        setEco(eco);
        setPm(eco.getServer().getPluginManager());
        setPlayerAccountManager(eco.getPlayerAccountManager());
        setL(this);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage("Le nouveau venu va avoir son compte en banque olallalala !");

        } else {
            Bukkit.broadcastMessage("Celui là a déjà un compte en banque olalalalla !");
        }
    }

    public Listener getL() {
        return this.l;
    }

    public void setL(Listener newL) {
        this.l = newL;
    }

    public PluginManager getPm() {
        return this.pm;
    }

    public void setPm(PluginManager newPm) {
        this.pm = newPm;
    }

    public PlayerAccountManager getPlayerAccountManager() {
        return this.playerAccountManager;
    }

    public void setPlayerAccountManager(PlayerAccountManager newPlayerAccountManager) {
        this.playerAccountManager = newPlayerAccountManager;
    }

    public Economia getEco() {
        return this.eco;
    }

    public void setEco(Economia newEco) {
        this.eco = newEco;
    }
}
