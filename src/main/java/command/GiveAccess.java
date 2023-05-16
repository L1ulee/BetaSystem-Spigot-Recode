package command;

import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import utils.KeyManager;
import utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveAccess implements CommandExecutor{
    public GiveAccess() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String UUID;
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (!p.hasPermission("betasystem.giveaccess") && !p.hasPermission("betasystem.*")) {
                if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPermsCN);
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPerms);
                }
            } else if (args.length == 0) {
                p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "/giveaccess <§eName§7>");
            } else {
                UUID = UUIDFetcher.getUUID(args[0]);
                if (BetaSystem_Spigot_Recode.cracked) {
                    UUID = args[0];
                }

                if (UUID != null) {
                    String Key = KeyCreate.randomAlphaNumeric(15);
                    KeyManager.createKey(Key, p.getUniqueId().toString());
                    KeyManager.setKeyOwner(Key, UUID);
                    if (BetaSystem_Spigot_Recode.chinese) {
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "玩家 §e§l" + args[0] + " §7现在可以加入 §a服务器");
                    } else {
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "The player §e§l" + args[0] + " §7can §ajoin §7now the server");
                    }
                } else if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§c此Minecraft账号不存在");
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cThis Minecraft account doesn't exists");
                }
            }
        } else if (args.length == 0) {
            Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "/giveaccess <§eName§7>");
        } else {
            UUID = UUIDFetcher.getUUID(args[0]);
            if (BetaSystem_Spigot_Recode.cracked) {
                UUID = args[0];
            }

            if (UUID != null) {
                UUID = KeyCreate.randomAlphaNumeric(15);
                KeyManager.createKey(UUID, "null");
                KeyManager.setKeyOwner(UUID, UUID);
                if (BetaSystem_Spigot_Recode.chinese) {
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "玩家 §e§l" + args[0] + " §7现在可以加入 §a服务器");
                } else {
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "The player §e§l" + args[0] + " §7can §ajoin §7now the server");
                }
            } else if (BetaSystem_Spigot_Recode.chinese) {
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§c此Minecraft账号不存在");
            } else {
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cThis Minecraft account doesn't exists");
            }
        }

        return false;
    }
}
