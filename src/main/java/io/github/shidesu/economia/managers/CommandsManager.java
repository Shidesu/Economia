package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import io.github.shidesu.economia.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Alexandre on 27/02/2017.
 */
public class CommandsManager implements CommandExecutor {

    private Economia eco;

    public CommandsManager(Economia eco) {
        this.eco = eco;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PlayerManager p = new PlayerManager((Player) sender);
        if (command.getName().equalsIgnoreCase("ecopaid") && args.length >= 2 && Utils.isStringOnlinePlayer(args[0]) && Utils.isInt(args[1])) {
            PlayerMoneyManager.setMoneyMap(args[1], p);
            ecopaidCommand(p);
            return true;
        } else if (command.getName().equalsIgnoreCase("ecopaid") && args.length == 0) {
            Bukkit.broadcastMessage("Vous avez payé le vent");
            return true;
        }

        return false;
    }

    private void ecopaidCommand(PlayerManager p) {
        Bukkit.broadcastMessage("Vous avez utilisé la commande de test ://");
        eco.getPlayerMoneyManager().withdrawPlayer(PlayerMoneyManager.getParseInt(p), p);
    }
}
