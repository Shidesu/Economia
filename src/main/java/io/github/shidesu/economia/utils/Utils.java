package io.github.shidesu.economia.utils;

import io.github.shidesu.economia.managers.PlayerManager;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Alexandre on 04/03/2017.
 */
public class Utils {

    private static Map<UUID, Integer> moneyArgEcopaid = new HashMap<>();

    public static boolean isInt(String s, PlayerManager p){
        try{
            int amount = Integer.parseInt(s);
            moneyArgEcopaid.put(p.getUniqueId(), amount);
            Bukkit.broadcastMessage("Todo va bene");
            return true;
        }catch(NumberFormatException e){
            Bukkit.broadcastMessage("aie aie aie muchachos");
            return false;
        }
    }

    public static int getParseInt(PlayerManager p) {
        return moneyArgEcopaid.get(p.getUniqueId());
    }

}
