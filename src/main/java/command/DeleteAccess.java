package command;

import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import utils.KeyManager;
import utils.UUIDFetcher;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteAccess implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (!p.hasPermission("betasystem.deleteaccess") && !p.hasPermission("betasystem.*")) {
                if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPermsCN);
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPerms);
                }
            } else if (args.length == 0) {
                p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "/deleteaccess <§eName§7>");
            } else {
                String UUID = UUIDFetcher.getUUID(args[0]);
                if (BetaSystem_Spigot_Recode.cracked) {
                    UUID = args[0];
                }

                if (UUID != null) {
                    KeyManager.deleteKeyByUUID(UUID);
                    if (BetaSystem_Spigot_Recode.chinese) {
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "玩家 §e§l" + args[0] + " §7现在 §c无法 §7加入服务器");
                    } else {
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "The player §e§l" + args[0] + " §ccan't §7join the server now");
                    }
                } else if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§c此Minecraft账号不存在");
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cThis Minecraft account doesn't exists");
                }

                Player lostaccess = Bukkit.getPlayerExact(args[0]);
                if (lostaccess != null) {
                    if (BetaSystem_Spigot_Recode.chinese) {
                        lostaccess.kickPlayer("§c你没有 §c§lBeta访问资格 §c请联系 §4管理员 §c了解更多信息");
                    } else {
                        lostaccess.kickPlayer("§cYou have been denied §c§lbeta access §cby an §4admin§c.");
                    }
                }
            }
        } else if (args.length == 0) {
            Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "/deleteaccess <§eName§7>");
        } else {
            String UUID = UUIDFetcher.getUUID(args[0]);
            if (BetaSystem_Spigot_Recode.cracked) {
                UUID = args[0];
            }

            if (UUID != null) {
                KeyManager.deleteKeyByUUID(UUID);
                if (BetaSystem_Spigot_Recode.chinese) {
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "玩家 §e§l" + args[0] + " §7现在 §c无法 §7加入服务器");
                } else {
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "The player §e§l" + args[0] + " §ccan't §7join the server now");
                }
            } else if (BetaSystem_Spigot_Recode.chinese) {
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§c此Minecraft账号不存在");
            } else {
                Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cThis Minecraft account doesn't exists");
            }

            Player lostaccess = Bukkit.getPlayerExact(args[0]);
            if (lostaccess != null) {
                if (BetaSystem_Spigot_Recode.chinese) {
                    lostaccess.kickPlayer("§c你没有 §c§lBeta访问资格 §c请联系 §4管理员 §c了解更多信息");
                } else {
                    lostaccess.kickPlayer("§cYou have been denied §c§lbeta access §cby an §4admin§c.");
                }
            }
        }

        return false;
    }
}
