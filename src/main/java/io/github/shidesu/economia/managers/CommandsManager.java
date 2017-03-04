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
    //Bukkit.getOnlinePlayers().stream().filter((p) -> p.getName().equals("Pseudo")).findFirst();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ecopaid") && args.length >= 2 && args[0].equals("Test") && Utils.isInt(args[1])) {
            ecopaidCommand((Player)sender);
            return true;
        } else if (command.getName().equalsIgnoreCase("ecopaid")) {
            Bukkit.broadcastMessage("Vous avez payé le vent");
            return true;
        }

        return false;
    }

    private void ecopaidCommand(Player p){
        PlayerManager pm = new PlayerManager(p);
        Bukkit.broadcastMessage("Vous avez utilisé la commande de test ://");
        eco.getPlayerMoneyManager().withdrawPlayer(10,pm);
    }
}
