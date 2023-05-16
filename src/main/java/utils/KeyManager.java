package utils;

import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KeyManager {
    public KeyManager() {
    }

    public static boolean hasBetaAccess(String UUID) {
        try {
            ResultSet rs = BetaSystem_Spigot_Recode.mysql.query("SELECT * FROM beta WHERE UUID='" + UUID + "'");
            if (rs.next()) {
                return rs.getString("UUID") != null;
            }
        } catch (SQLException var2) {
        }

        return false;
    }

    public static boolean isKeyExists(String Key) {
        try {
            ResultSet rs = BetaSystem_Spigot_Recode.mysql.query("SELECT * FROM beta WHERE BETAKEY='" + Key + "'");
            if (rs.next()) {
                return rs.getString("BETAKEY") != null;
            }
        } catch (SQLException var2) {
        }

        return false;
    }

    public static void createKey(String Key, String CreatorUUID) {
        BetaSystem_Spigot_Recode.mysql.update("INSERT INTO beta(BETAKEY, UUID, CREATOR, DATE) VALUES ('" + Key + "', 'null', '" + CreatorUUID + "', '" + System.currentTimeMillis() + "')");
    }

    public static void setKeyOwner(String Key, String OwnerUUID) {
        BetaSystem_Spigot_Recode.mysql.update("UPDATE beta SET UUID = '" + OwnerUUID + "' WHERE BETAKEY = '" + Key + "'");
    }

    public static void deleteKey(String Key) {
        BetaSystem_Spigot_Recode.mysql.update("DELETE FROM beta WHERE BETAKEY = '" + Key + "'");
    }

    public static void deleteKeyByUUID(String UUID) {
        BetaSystem_Spigot_Recode.mysql.update("DELETE FROM beta WHERE UUID = '" + UUID + "'");
    }
}
