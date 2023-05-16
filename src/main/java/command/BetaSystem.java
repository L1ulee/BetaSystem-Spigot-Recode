package command;

import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BetaSystem implements CommandExecutor{
    public BetaSystem() {
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player)sender;
        if (BetaSystem_Spigot_Recode.chinese) {
            p.sendMessage("");
            p.sendMessage("§9§lBeta内测系统 §8| §7版本: §c" + BetaSystem_Spigot_Recode.Version);
            p.sendMessage("§c§l当前支持的Minecraft版本 §4§l1.12x - 1.15x");
            p.sendMessage("§7开发者: §e§lTutorialwork");
            p.sendMessage("§7重新编码 by L1ulee");
            p.sendMessage("§7开发者信息: " + BetaSystem_Spigot_Recode.DevMsg);
            p.sendMessage("");
        } else {
            p.sendMessage("");
            p.sendMessage("§8[]===================================[]");
            p.sendMessage("§e§lBetaSystem §8• §7Version §8» §c" + BetaSystem_Spigot_Recode.Version);
            p.sendMessage("§7Developer §8» §e§lTutorialwork");
            p.sendMessage("§7Recoded by L1ulee");
            p.sendMessage("§7Developer Message: " + BetaSystem_Spigot_Recode.DevMsg);
            p.sendMessage("");
        }

        return false;
    }
}
