package io.github.shidesu.economia.managers;

import io.github.shidesu.economia.Economia;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Alexandre on 27/02/2017.
 */
public class CommandsManager implements CommandExecutor {

    private Economia eco;

    public CommandsManager(Economia eco){
        this.eco = eco;
    }
    //Bukkit.getOnlinePlayers().stream().filter((p) -> p.getName().equals("Pseudo")).findFirst();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equalsIgnoreCase("ecopaid") && args.length >= 1 && args[0].equals("Test")){
            Bukkit.broadcastMessage("Vous avez utilisé la commande de test ://");
            return true;
        }else if(command.getName().equalsIgnoreCase("ecopaid")){
            Bukkit.broadcastMessage("Vous avez payé le vent");
            return true;
        }

        return false;
    }
}
