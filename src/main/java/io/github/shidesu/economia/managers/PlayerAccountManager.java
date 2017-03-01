package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandre on 23/02/2017.
 */
public class PlayerAccountManager {
    private Economia eco;
    private String fileAccountPath;
    private File file;
    private File usermapFile;
    private FileConfiguration fileConfiguration;
    private FileConfiguration usermap;


    public PlayerAccountManager(Economia eco) {
        this.eco = eco;
    }


    public void getAccount(PlayerManager p) {                               /*This method will be use to get data stored in the yaml file*/
        file = new File(eco.getDataFolder() + "/PlayerData", p.getUniqueIdString() + ".yml");
        if (file.exists()) {
            eco.getLogger().info(p.getName() + " a déjà un compte !");
            fileConfiguration = YamlConfiguration.loadConfiguration(file);
            int test = (int) fileConfiguration.get("Money");
            Bukkit.broadcastMessage(p.getName() + " a " + test + " abyss !!!");
        } else {
            Bukkit.broadcastMessage("noob tu pues en codage kao");
            createAccount(p);
        }

    }

    public void createAccount(PlayerManager p) {                            /* Send the player manager to mapData which store them into a map<String,Object> and finally save everything in the yaml file with saveData*/

        putData(p);
        saveData(p);


    }

    private void saveData(PlayerManager p) {
        file = new File(eco.getDataFolder() + "/PlayerData", p.getUniqueIdString() + ".yml");

        try {
            fileConfiguration.save(file);
            usermap.save(usermapFile);
            eco.getLogger().info("Le compte a bien été créé.");

        } catch (IOException e) {
            String error = e.getMessage();
            eco.getLogger().info(error);
        }
    }

    private FileConfiguration putData(PlayerManager p) {
        usermapFile = new File(eco.getDataFolder(), "usermap.yml");
        FileConfiguration defConf = YamlConfiguration.loadConfiguration(new File(eco.getDataFolder(), "config.yml"));
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
        List<String> banks = new ArrayList<>();
        banks.add("test");
        banks.add("truc");
        fileConfiguration.set("Name", p.getName());
        fileConfiguration.set("UUID", p.getUniqueIdString());
        fileConfiguration.set("Money", defConf.getInt("StartingBalance"));
        fileConfiguration.set("Banks", banks);

        if (usermapFile.exists()) {
            usermap = YamlConfiguration.loadConfiguration(usermapFile);
            usermap.set(p.getName(), p.getUniqueIdString());
        } else {
            eco.saveResource("usermap.yml", false);
            usermap = YamlConfiguration.loadConfiguration(usermapFile);
            usermap.set(p.getName(), p.getUniqueIdString());

        }

        return fileConfiguration;
    }

}
