package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexandre on 23/02/2017.
 */
public class PlayerAccountManager implements Listener {
    private Economia eco;
    private String fileAccountPath;
    private File file;
    private FileConfiguration fileConfiguration;

    public PlayerAccountManager(Economia eco) {
        this.eco = eco;
    }


    public void getAccount(PlayerManager p) {                               /*This method will be use to get data stored in the yaml file*/
        file = new File(eco.getDataFolder() + "/PlayerData", p.getUniqueIdString() + ".yml");
        if (file.exists()) {
            eco.getLogger().info(p.getName() + " a déjà un compte !");
        } else
            createAccount(p);

    }

    public void createAccount(PlayerManager p) {                            /* Send the player manager to mapData which store them into a map<String,Object> and finally save everything in the yaml file with saveData*/
        Map<String, Object> playerData = new HashMap<>();
        playerData = mapData(p);
        saveData(playerData, p);


    }

    private void saveData(Object playerData, PlayerManager p) {
        file = new File(eco.getDataFolder() + "/PlayerData", p.getUniqueIdString() + ".yml");
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
        fileConfiguration.set("Player Data", playerData);

        try {
            fileConfiguration.save(file);
            eco.getLogger().info("Le compte a bien été créé.");

        } catch (IOException e) {
            String error = e.getMessage();
            eco.getLogger().info(error);
        }
    }

    private Map<String, Object> mapData(PlayerManager p) {
        Map<String, Object> playerData = new HashMap<String, Object>();
        List<String> banks = new ArrayList<>();
        banks.add("test");
        banks.add("truc");
        playerData.put("Name", p.getName());
        playerData.put("UUID", p.getUniqueIdString());
        playerData.put("Money", 100);
        playerData.put("Banks", banks);

        return playerData;
    }

}
