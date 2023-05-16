package command;

import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import utils.KeyManager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KeyCreate implements CommandExecutor{
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public KeyCreate() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (!p.hasPermission("betasystem.createkey") && !p.hasPermission("betasystem.*")) {
                if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPermsCN);
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPerms);
                }
            } else {
                String Key = randomAlphaNumeric(15);
                String Pastebin = BetaSystem_Spigot_Recode.callURL("https://tutorialwork.000webhostapp.com/pastebin.php?key=" + Key);
                String UUID = p.getUniqueId().toString();
                if (BetaSystem_Spigot_Recode.cracked) {
                    UUID = p.getName();
                }

                KeyManager.createKey(Key, UUID);
                if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§aBeta密钥已创建!");
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "链接: §9" + Pastebin);
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§aA Betakey was created!");
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "Link: §9" + Pastebin);
                }
            }
        } else {
            String Key = randomAlphaNumeric(15);
            KeyManager.createKey(Key, "null");
            if (BetaSystem_Spigot_Recode.chinese) {
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§aBeta密钥已创建!");
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "密钥: §9" + Key);
            } else {
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§aA Betakey was created!");
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "Key: §9" + Key);
            }
        }

        return false;
    }

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();

        while(count-- != 0) {
            int character = (int)(Math.random() * (double)"ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".length());
            builder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(character));
        }

        return builder.toString();
    }
}
