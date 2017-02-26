package io.github.shidesu.economia;

import io.github.shidesu.economia.managers.EventManager;
import io.github.shidesu.economia.managers.PlayerAccountManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class Economia extends JavaPlugin {
    private PlayerAccountManager playerAccountManager;
    private EventManager eventManager;
    private FileConfiguration fileConfiguration;
    private File fileConf;

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
        loadConfig();
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

    public void loadConfig() {
        this.fileConf = new File(getDataFolder(), "config.yml");
        if (fileConf.exists()) {
            this.fileConfiguration = YamlConfiguration.loadConfiguration(fileConf);
        } else {
            saveResource("config.yml", false);  //saveResource try to get the file named config.yml in the resources folder of the program and then saved it in the plugin Economia data folder.

        }

    }

    public FileConfiguration getFileConfiguration() {
        return this.fileConfiguration;
    }

    public void setFileConfiguration(FileConfiguration f) {
        this.fileConfiguration = f;
    }

}