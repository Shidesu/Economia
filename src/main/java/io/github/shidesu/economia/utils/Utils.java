package io.github.shidesu.economia.utils;

import io.github.shidesu.economia.managers.PlayerManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Alexandre on 04/03/2017.
 */
public class Utils {

    private static Map<UUID, Integer> moneyMap = new HashMap<>();

    public static boolean isInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public static void setMoneyMap(String s, PlayerManager p){
        try{
            int amount = Integer.parseInt(s);
            moneyMap.put(p.getUniqueId(), amount);
        }catch(NumberFormatException e){

        }
    }

    public static int getParseInt(PlayerManager p) {
        return moneyMap.get(p.getUniqueId());
    }

}
