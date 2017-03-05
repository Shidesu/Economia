package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Alexandre on 04/03/2017.
 */
public class PlayerMoneyManager {
    private static Map<UUID, Integer> moneyMap = new HashMap<>();
    private Economia eco;
    private PlayerAccountManager pam;
    private File dataFile;
    private YamlConfiguration dataYaml;
    private int money;

    public PlayerMoneyManager(Economia eco) {
        this.eco = eco;
        this.pam = eco.getPlayerAccountManager();
    }

    public static void setMoneyMap(String s, PlayerManager p) {
        try {
            int amount = Integer.parseInt(s);
            moneyMap.put(p.getUniqueId(), amount);
        } catch (NumberFormatException e) {

        }
    }

    public static int getParseInt(PlayerManager p) {
        return moneyMap.get(p.getUniqueId());
    }

    public void withdrawPlayer(int withdrawAmount, PlayerManager p) {

        if (pam.getAccount(p)) {
            initPlayerAccountManagerFiles(p);
            money = (int) dataYaml.get("Money");
            int newAmount = money - withdrawAmount;
            dataYaml.set("Money", newAmount);
            saveAmount();
        }
    }

    private void saveAmount() {
        try {
            dataYaml.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initPlayerAccountManagerFiles(PlayerManager p) {
        //pam.getAccount(p);
        this.dataFile = pam.getDataFile();
        this.dataYaml = pam.getDataYaml();

    }

    public void setDataFile(File f) {
        this.dataFile = pam.getDataFile();
    }

    public void setDataYaml(YamlConfiguration y) {

        this.dataYaml = pam.getDataYaml();
    }

}


