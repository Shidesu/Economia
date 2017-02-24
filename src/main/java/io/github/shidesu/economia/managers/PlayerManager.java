package io.github.shidesu.economia.managers;

import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Alexandre on 24/02/2017.
 */
public class PlayerManager {
    private String name;
    private String nickName;
    private UUID uniqueId;

    public PlayerManager(Player p){
        this.name = p.getName();
        this.nickName = p.getDisplayName();
        this.uniqueId = p.getUniqueId();
    }
}
