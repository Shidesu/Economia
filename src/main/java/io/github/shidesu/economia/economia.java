package io.github.shidesu.economia;

import io.github.shidesu.economia.managers.eventManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class economia extends JavaPlugin {

    @Override
    public void onEnable(){
        Listener one = new eventManager(this);
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(one, this);
        getLogger().info("Economia chargée !");

    }

    @Override
    public void onDisable(){
        getLogger().info("Economia désactivée !");
    }


}
