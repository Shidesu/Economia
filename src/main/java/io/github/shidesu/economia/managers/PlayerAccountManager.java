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
    private File dataFile;
    private File usermapFile;
    private FileConfiguration dataYaml;
    private FileConfiguration usermapYaml;
    private PlayerManager p;


    public PlayerAccountManager(Economia eco) {
        this.eco = eco;
    }


    public boolean getAccount(PlayerManager p) {                               /*This method will be use to get data stored in the yaml file*/
        this.p = p;
        eco.getLogger().info(eco.getConfigManager().toString());
        initFile();
        if (dataFile.exists()) {
            initYaml();
            eco.getLogger().info(p.getName() + " a déjà un compte !");
            int test = (int) dataYaml.get("Money");
            Bukkit.broadcastMessage(p.getName() + " a " + test + " abyss !!!");
            return true;
        } else {
            Bukkit.broadcastMessage("noob tu pues en codage kao");
            createFile();
            initYaml();
            createAccount(p);
            return false;
        }

    }

    public void createAccount(PlayerManager p) {                            /* Send the player manager to mapData which store them into a map<String,Object> and finally save everything in the yaml file with saveData*/

        putData(p);
        saveData(p);


    }

    private void saveData(PlayerManager p) {

        try {
            dataYaml.save(dataFile);
           // usermapYaml.save(usermapFile);
            eco.getLogger().info("Le compte a bien été créé.");

        } catch (IOException e) {
            String error = e.getMessage();
            eco.getLogger().info(error);
        }
    }

    private FileConfiguration putData(PlayerManager p) {
        int startBalance = eco.getConfigManager().getStartingBalance();
        List<String> banks = new ArrayList<>();
        banks.add("test");
        banks.add("truc");
        dataYaml.set("Name", p.getName());
        dataYaml.set("UUID", p.getUniqueIdString());
        dataYaml.set("Money", startBalance);
        dataYaml.set("Banks", banks);



        return dataYaml;
    }

    private void initFile() {
        this.dataFile = new File(eco.getDataFolder() + "/PlayerData", p.getUniqueIdString() + "config.yml");

    }

    private void createFile(){
        if (!this.dataFile.exists()){
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