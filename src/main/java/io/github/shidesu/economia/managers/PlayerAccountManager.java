package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alexandre on 23/02/2017.
 */
public class PlayerAccountManager {
    private Economia eco;
    private File dataFile;
    private YamlConfiguration dataYaml;
    private PlayerManager p;


    public PlayerAccountManager(Economia eco) {
        this.eco = eco;
    }


    public boolean getAccount(PlayerManager p) {                               /*This method will be use to get data stored in the yaml file*/
        this.p = p;
        eco.getLogger().info(eco.getConfigManager().toString());
        initFile(this.p);
        if (dataFile.exists()) {
            initYaml();
            eco.getLogger().info(p.getName() + " a déjà un compte !");
            int test = (int) dataYaml.get("Money");
            Bukkit.broadcastMessage(p.getName() + " a " + test + " abyss !!!");
            return true;
        } else {
            Bukkit.broadcastMessage("noob tu pues en codage kao");
            createFile();
            createAccount(p);
            return false;
        }

    }

    public boolean createAccount(PlayerManager p) {                            /* Send the player manager to mapData which store them into a map<String,Object> and finally save everything in the yaml file with saveData*/
        initFile(p);
        initYaml();
        putData(p);
        boolean isCreated = saveData(p);

        return isCreated;

    }

    private boolean saveData(PlayerManager p) {

        try {
            dataYaml.save(dataFile);
            eco.getConfigManager().getUsermapYaml().save(eco.getConfigManager().getUsermapFile());
            eco.getLogger().info("Le compte a bien été créé.");

            return true;

        } catch (IOException e) {
            String error = e.getMessage();
            eco.getLogger().info(error);
            return false;
        }
    }

    private FileConfiguration putData(PlayerManager p) {
        int startBalance = eco.getConfigManager().getStartingBalance();
        dataYaml.set("Name", p.getName());
        dataYaml.set("UUID", p.getUniqueIdString());
        dataYaml.set("Money", startBalance);
        eco.getConfigManager().getUsermapYaml().set(p.getName(), p.getUniqueIdString());

        return dataYaml;
    }

    private void initFile(PlayerManager p) {
        this.dataFile = new File(eco.getDataFolder() + "/PlayerData", p.getUniqueIdString() + ".yml");

    }

    private void createFile() {
        if (!this.dataFile.exists()) {
            try {
                this.dataFile.createNewFile();
            } catch (IOException e) {
                eco.getLogger().info(e.getMessage());
            }
        }
    }

    private void initYaml() {
        this.dataYaml = YamlConfiguration.loadConfiguration(dataFile);

    }

    public File getDataFile(){
        return this.dataFile;
    }
    public YamlConfiguration getDataYaml(){
        return this.dataYaml;
    }

}
/*
if (usermapFile.exists()) {
        usermapYaml = YamlConfiguration.loadConfiguration(usermapFile);
        usermapYaml.set(p.getName(), p.getUniqueIdString());
        } else {
        eco.saveResource("usermap.yml", false);
        usermapYaml = YamlConfiguration.loadConfiguration(usermapFile);
        usermapYaml.set(p.getName(), p.getUniqueIdString());

        }*/