package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.event.Listener;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexandre on 23/02/2017.
 */
public class PlayerAccountManager implements Listener {

    Economia eco;

    public PlayerAccountManager(Economia eco) {
        this.eco = eco;
    }


    private void getAccount(PlayerManager p){
        
    }

    private void createAccount(/*OfflinePlayer p*/) {
    //    UUID uuid = p.getUniqueId();
     //   String playerId = uuid.toString();
        Map<String, Object> playerData = new HashMap<String, Object>();
        playerData.put("UUID", "taratata-25-25");
        Yaml yaml = new Yaml();
        File f = null;
        try {
            f = eco.getDataFolder();
            String filePath = f.getPath();
            f.mkdirs();
            eco.getLogger().info(filePath);
            f = new File(filePath + "/lol.yml");
            FileWriter writer = new FileWriter(f);
            yaml.dump(playerData, writer);
        } catch (Exception e) {
            String error = e.getMessage();
            eco.getLogger().info(error);
        }
    }

}
