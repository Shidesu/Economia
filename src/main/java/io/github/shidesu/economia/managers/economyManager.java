package io.github.shidesu.economia.managers;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;

import java.util.List;

/**
 * Created by Alexandre on 22/02/2017.
 */
public class economyManager implements Economy {

    @Override
    public EconomyResponse createBank(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public EconomyResponse createBank(String s, String s1) {
        return null;
    }


    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {
        return false;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer, String s) {
        return false;
    }


    @Override
    public boolean createPlayerAccount(String s, String s1) {
        return false;
    }


    @Override
    public String format(double v) {
        return null;
    }

    @Override
    public int fractionalDigits() {
        return 0;
    }

    @Override
    public boolean createPlayerAccount(String s) {
        return false;
    }

/*Withdraw Methods*/
/*These methods are used for withdrawing an amount of money from the player account or the player bank account.
* Deprecated methods surely won't be define as they can't guarantee to link to the right player.*/
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
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
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

    @Override
    public EconomyResponse depositPlayer(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(String s, String s1, double v) {
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double v) {
        return null;
    }


    @Override
    public double getBalance(OfflinePlayer offlinePlayer) {
        return 0;
    }

    @Override
    public double getBalance(String s) {
        return 0;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return null;
    }

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
