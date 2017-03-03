package io.github.shidesu.economia.Vault;

import io.github.shidesu.economia.Economia;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.List;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class VaultInteractions implements Economy {

    private Economia eco;

    public VaultInteractions(Economia eco) {
        this.eco = eco;
    }

    @Override
    public boolean isEnabled() {
        return eco.isEnabled();
    }


/*createBank methods*/

    @Override
    public EconomyResponse createBank(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Deprecated
    @Override
    public EconomyResponse createBank(String s, String s1) {
        return null;
    }

/*End createBank methods*/
/*createPlayerAccount methods*/

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {

        Bukkit.broadcastMessage(offlinePlayer.getName() + "'s account created");

        return false;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer, String s) {
        return false;
    }

    @Deprecated
    @Override
    public boolean createPlayerAccount(String s) {
        return false;
    }

    @Deprecated
    @Override
    public boolean createPlayerAccount(String s, String s1) {
        return false;
    }

    /*End createPlayerAccount methods*/
    @Override
    public String format(double v) {
        return null;
    }

    @Override
    public int fractionalDigits() {
        return 0;
    }


    /*Withdraw Methods*/
/*Withdraw player methods*/
    @Deprecated
    @Override
    public EconomyResponse withdrawPlayer(String s, double v) {
        return null;
    }

    @Deprecated
    @Override
    public EconomyResponse withdrawPlayer(String s, String s1, double v) {
        return null;
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double v) {
        return null;
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return null;
    }

/*End Withdraw player methods*/

/*Withdraw bank methods*/

    @Override
    public EconomyResponse bankWithdraw(String s, double v) {
        return null;
    }

/*End Withdraw bank methods*/

/*End Withdraw methods*/

/*hasAccount methods*/

    @Deprecated
    @Override
    public boolean hasAccount(String s, String s1) {
        return false;
    }

    @Deprecated
    @Override
    public boolean hasAccount(String s) {
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer) {
        return false;
    }

    /*End hasAccount methods*/
/*has methods*/
    @Deprecated
    @Override
    public boolean has(String s, double v) {
        return false;
    }

    @Deprecated
    @Override
    public boolean has(String s, String s1, double v) {
        return false;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, String s, double v) {
        return false;
    }


    @Override
    public boolean has(OfflinePlayer offlinePlayer, double v) {


        return false;
    }


/*End has methods*/

    @Override
    public EconomyResponse bankBalance(String s) {
        return null;
    }

    @Override
    public EconomyResponse deleteBank(String s) {
        return null;
    }

    @Override
    public double getBalance(String s, String s1) {
        return 0;
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer, String s) {
        return 0;
    }

    @Override
    public String getName() {
        return "Economia";
    }

    @Override
    public EconomyResponse isBankOwner(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse bankHas(String s, double v) {
        return null;
    }

    @Override
    public List<String> getBanks() {
        return null;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer, String s) {
        return false;
    }

    /*depositPlayer methods*/
    @Deprecated
    @Override
    public EconomyResponse depositPlayer(String s, double v) {
        return null;
    }

    @Deprecated
    @Override
    public EconomyResponse depositPlayer(String s, String s1, double v) {
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double v) {
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return null;
    }

    /*End depositPlayer methods*/
/*getBalance methods*/
    @Override
    public double getBalance(OfflinePlayer offlinePlayer) {
        return 0;
    }

    @Deprecated
    @Override
    public double getBalance(String s) {
        return 0;
    }

    /*End getBalance methods*/
    @Override
    public EconomyResponse isBankOwner(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public EconomyResponse bankDeposit(String s, double v) {
        return null;
    }

    @Override
    public String currencyNamePlural() {
        return null;
    }

    @Override
    public String currencyNameSingular() {
        return null;
    }
}
