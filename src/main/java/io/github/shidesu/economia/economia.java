package io.github.shidesu.economia;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class economia extends JavaPlugin {

    @Override
    public void onEnable(){
        getLogger().info("Economia chargée !");
    }

    @Override
    public void onDisable(){
        getLogger().info("Economia désactivée !");
    }


}
