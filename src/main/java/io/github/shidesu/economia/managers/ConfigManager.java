package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by Alexandre on 02/03/2017.
 */
public class ConfigManager {
    private Economia eco;
    private File configFile;
    private File usermapFile;
    private YamlConfiguration configYaml;
    private YamlConfiguration usermapYaml;

    public ConfigManager(Economia eco) {
        this.eco = eco;
        initFiles();
    }

    private void initFiles() {
        this.configFile = new File(eco.getDataFolder(), "config.yml");
        this.usermapFile = new File(eco.getDataFolder(), "usermap.yml");
        initYaml();
    }

    private void initYaml() {
        if (this.configFile.exists()) {
            this.configYaml = YamlConfiguration.loadConfiguration(configFile);
        } else if (!this.configFile.exists()) {
            eco.saveResource("config.yml", false);
            this.configYaml =  YamlConfiguration.loadConfiguration(configFile);
        }

        if (this.usermapFile.exists()) {
            this.usermapYaml = YamlConfiguration.loadConfiguration(usermapFile);
        } else if (!this.usermapFile.exists()) {
            eco.saveResource("usermap.yml", false);
            this.usermapYaml = YamlConfiguration.loadConfiguration(usermapFile);
        }
    }

    public File getConfigFile() {
        return this.configFile;
    }

    public File getUsermapFile() {
        return this.usermapFile;
    }

    public YamlConfiguration getConfigYaml() {
        return this.configYaml;
    }

    public YamlConfiguration getUsermapYaml() {
        return this.usermapYaml;
    }

    public String getLocalization() {
        return this.configYaml.getString("PluginLocalization");
    }

    public int getStartingBalance() {
        return this.configYaml.getInt("StartingBalance");
    }

    public boolean getUseEssentialsEco() {
        return this.configYaml.getBoolean("EssentialsEco");
    }

    @Override
    public String toString() {
        return "Je suis du déboguage";
    }

}
