package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by Alexandre on 04/03/2017.
 */
public class PlayerMoneyManager {
    private Economia eco;
    private PlayerAccountManager pam;
    private File dataFile;
    private YamlConfiguration dataYaml;
    private int money;

    public PlayerMoneyManager(Economia eco){
        this.eco = eco;
        this.pam = eco.getPlayerAccountManager();
        this.dataFile = pam.getDataFile();
        this.dataYaml = pam.getDataYaml();
    }

    public void withdrawPlayer(int withdrawAmount, PlayerManager p){
        if(pam.getAccount(p)){
           money =(int) dataYaml.get("Money");
           dataYaml.set("Money", money - withdrawAmount);
        }
    }

}
