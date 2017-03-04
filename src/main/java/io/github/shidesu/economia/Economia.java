package io.github.shidesu.economia;

import io.github.shidesu.economia.managers.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class Economia extends JavaPlugin {
    private PlayerAccountManager playerAccountManager;
    private EventManager eventManager;
    private CommandsManager commandsManager;
    private ConfigManager configManager;
    private PlayerMoneyManager playerMoneyManager;


    @Override
    public void onEnable() {
        initManagers();
        initDirs();
        initCommands();
        eventManager.getPm().registerEvents(eventManager.getL(), eventManager.getEco());
        getLogger().info("[Economia] Economia chargée !");
        getLogger().info(getDataFolder().getPath());

    }

    @Override
    public void onDisable() {
        getLogger().info("Economia désactivée !");
    }

    private void initCommands() {
        getCommand("ecopaid").setExecutor(commandsManager);
    }

    private void initManagers() {
        playerAccountManager = new PlayerAccountManager(this);
        eventManager = new EventManager(this);
        commandsManager = new CommandsManager(this);
        configManager = new ConfigManager(this);
        playerMoneyManager = new PlayerMoneyManager(this);

    }

    private void initDirs() {
        File f = new File(getDataFolder() + "/PlayerData");
        if (!f.exists()) {
            f.mkdirs();

        }
    }


    public PlayerAccountManager getPlayerAccountManager() {

        return this.playerAccountManager;
    }

    public PlayerMoneyManager getPlayerMoneyManager() {
        return this.playerMoneyManager;
    }

    public ConfigManager getConfigManager() {

        return this.configManager;
    }
}