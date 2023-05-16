package command;

import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import utils.KeyManager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteKey implements CommandExecutor{
    public DeleteKey() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (!p.hasPermission("betasystem.deletekey") && !p.hasPermission("betasystem.*")) {
                if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPermsCN);
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPerms);
                }
            } else if (args.length == 0) {
                p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "/deletekey <§eKey§7>");
            } else {
                String Key = args[0];
                if (KeyManager.isKeyExists(Key)) {
                    KeyManager.deleteKey(Key);
                    if (BetaSystem_Spigot_Recode.chinese) {
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "密钥 §e§l" + args[0] + " §7已 §c删除");
                    } else {
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "The key §e§l" + args[0] + " §7was §cdeleted");
                    }
                } else if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cBeta密钥不存在");
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cThis betakey is not registered");
                }
            }
        } else if (args.length == 0) {
            Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "/giveaccess <§eName§7>");
        } else if (args.length == 0) {
            Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "/deletekey <§eKey§7>");
        } else {
            String Key = args[0];
            if (KeyManager.isKeyExists(Key)) {
                KeyManager.deleteKey(Key);
                if (BetaSystem_Spigot_Recode.chinese) {
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "密钥 §e§l" + args[0] + " §7已 §c删除");
                } else {
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "The key §e§l" + args[0] + " §7was §cdeleted");
                }
            } else if (BetaSystem_Spigot_Recode.chinese) {
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cBeta密钥不存在");
            } else {
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cThis betakey is not registered");
            }
        }

        return false;
    }
}
