package io.github.shidesu.economia.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Alexandre on 04/03/2017.
 */
public class Utils {

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Player stringToPlayer(String name) {

        Player p = Bukkit.getOnlinePlayers().stream().filter(x -> x.getName().equals(name)).findFirst().get();

        return p;
    }

    public static boolean isStringOnlinePlayer(String name) {
        boolean test = Bukkit.getOnlinePlayers().stream().anyMatch(x -> x.getName().equals(name));

        return test;

    }
}

