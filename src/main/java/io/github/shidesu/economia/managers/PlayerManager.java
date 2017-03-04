package io.github.shidesu.economia.managers;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Alexandre on 24/02/2017.
 */
public class PlayerManager {
    private String name;
    private String nickName;
    private UUID uniqueId;
    private String uniqueIdString;

    public PlayerManager(Player p) {
        this.name = p.getName();
        this.nickName = p.getDisplayName();
        this.uniqueId = p.getUniqueId();
        this.uniqueIdString = p.getUniqueId().toString();
    }

    public PlayerManager(OfflinePlayer offPlayer) {
        this.name = offPlayer.getName();
        this.nickName = offPlayer.getName();
        this.uniqueId = offPlayer.getUniqueId();
        this.uniqueIdString = offPlayer.getUniqueId().toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String newNickName) {
        this.nickName = newNickName;
    }

    public UUID getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(UUID newUniqueId) {
        this.uniqueId = newUniqueId;
        setUniqueIdString(newUniqueId);
    }

    public String getUniqueIdString() {
        return this.uniqueIdString;
    }

    private void setUniqueIdString(UUID newUniqueId) {
        this.uniqueIdString = newUniqueId.toString();

    }
}
