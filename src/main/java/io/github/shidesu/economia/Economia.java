package io.github.shidesu.economia;

import io.github.shidesu.economia.managers.EventManager;
import io.github.shidesu.economia.managers.PlayerAccountManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class Economia extends JavaPlugin {
    private PlayerAccountManager playerAccountManager;
    private EventManager eventManager;

    private void initDirs() {
        File f = new File(getDataFolder() + "/PlayerData");
        if (!f.exists()) {
            f.mkdirs();

        }
    }

    @Override
    public void onEnable() {
        initManagers();
        initDirs();
        eventManager.getPm().registerEvents(eventManager.getL(), eventManager.getEco());
        getLogger().info("[Economia] Economia chargée !");
        getLogger().info(getDataFolder().getPath());

    }

    @Override
    public void onDisable() {
        getLogger().info("Economia désactivée !");
    }

    private void initManagers() {
        playerAccountManager = new PlayerAccountManager(this);
        eventManager = new EventManager(this);
    }


    public PlayerAccountManager getPlayerAccountManager() {
        return this.playerAccountManager;
    }
}