package command;

import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ToggleBeta implements CommandExecutor{
    public ToggleBeta() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (!p.hasPermission("betasystem.togglebeta") && !p.hasPermission("betasystem.*")) {
                if (BetaSystem_Spigot_Recode.chinese) {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPermsCN);
                } else {
                    p.sendMessage(BetaSystem_Spigot_Recode.NoPerms);
                }
            } else {
                File file = new File("plugins//BetaSystem//config.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                if (args.length == 0) {
                    if (cfg.getBoolean("BETAPHASE")) {
                        if (BetaSystem_Spigot_Recode.chinese) {
                            p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "已启用 §a§lBeta测试阶段");
                            p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§7§o关闭Beta测试阶段请输入: §e/togglebeta off");
                        } else {
                            p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "Currently is the beta phase §a§lactive");
                            p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§7§oTo disable it use: §e/togglebeta off");
                        }
                    } else if (BetaSystem_Spigot_Recode.chinese) {
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "已关闭 §c§lBeta测试阶段");
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§7§o启用Beta测试阶段请输入: §e/togglebeta on");
                    } else {
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "Currently is the beta phase §c§ldisabled");
                        p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "§7§oTo enable it use: §e/togglebeta on");
                    }
                } else {
                    if (args[0].equalsIgnoreCase("off")) {
                        if (cfg.getBoolean("BETAPHASE")) {
                            cfg.set("BETAPHASE", false);

                            try {
                                cfg.save(file);
                            } catch (IOException var10) {
                                var10.printStackTrace();
                            }

                            if (BetaSystem_Spigot_Recode.chinese) {
                                Bukkit.broadcastMessage(BetaSystem_Spigot_Recode.Prefix + "Beta测试阶段 §c已关闭");
                            } else {
                                Bukkit.broadcastMessage(BetaSystem_Spigot_Recode.Prefix + "The beta phase was §cdisabled");
                            }
                        } else if (BetaSystem_Spigot_Recode.chinese) {
                            p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "已关闭 §cBeta测试阶段");
                        } else {
                            p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "The beta phase is already §cdisabled");
                        }
                    }

                    if (args[0].equalsIgnoreCase("on")) {
                        if (!cfg.getBoolean("BETAPHASE")) {
                            cfg.set("BETAPHASE", true);

                            try {
                                cfg.save(file);
                            } catch (IOException var9) {
                                var9.printStackTrace();
                            }

                            if (BetaSystem_Spigot_Recode.chinese) {
                                Bukkit.broadcastMessage(BetaSystem_Spigot_Recode.Prefix + "Beta测试阶段 §a已开启");
                            } else {
                                Bukkit.broadcastMessage(BetaSystem_Spigot_Recode.Prefix + "The beta phase was §aenabled");
                            }
                        } else if (BetaSystem_Spigot_Recode.chinese) {
                            p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "已启用 §aBeta测试阶段");
                        } else {
                            p.sendMessage(BetaSystem_Spigot_Recode.Prefix + "The beta phase is already §aenabled");
                        }
                    }
                }
            }
        } else {
            File file = new File("plugins//BetaSystem//config.yml");
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            if (args.length == 0) {
                if (cfg.getBoolean("BETAPHASE")) {
                    if (BetaSystem_Spigot_Recode.chinese) {
                        Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "已启用 §a§lBeta测试阶段");
                        Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§7§o关闭Beta测试阶段请输入: §e/togglebeta off");
                    } else {
                        Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "Currently is the beta phase §a§lactive");
                        Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§7§oTo disable it use: §e/togglebeta off");
                    }
                } else if (BetaSystem_Spigot_Recode.chinese) {
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "已关闭 §c§lBeta测试阶段");
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§7§o启用Beta测试阶段请输入: §e/togglebeta on");
                } else {
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "Currently is the beta phase §c§ldisabled");
                    Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§7§oTo enable it use: §e/togglebeta on");
                }
            } else {
                if (args[0].equalsIgnoreCase("off")) {
                    if (cfg.getBoolean("BETAPHASE")) {
                        cfg.set("BETAPHASE", false);
                        if (BetaSystem_Spigot_Recode.chinese) {
                            Bukkit.broadcastMessage(BetaSystem_Spigot_Recode.Prefix + "Beta测试阶段 §c已关闭");
                        } else {
                            Bukkit.broadcastMessage(BetaSystem_Spigot_Recode.Prefix + "The beta phase was §cdisabled");
                        }
                    } else if (BetaSystem_Spigot_Recode.chinese) {
                        Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "已关闭 §cBeta测试阶段");
                    } else {
                        Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "The beta phase is already §cdisabled");
                    }
                }

                if (args[0].equalsIgnoreCase("on")) {
                    if (!cfg.getBoolean("BETAPHASE")) {
                        cfg.set("BETAPHASE", true);
                        if (BetaSystem_Spigot_Recode.chinese) {
                            Bukkit.broadcastMessage(BetaSystem_Spigot_Recode.Prefix + "Beta测试阶段 §a已开启");
                        } else {
                            Bukkit.broadcastMessage(BetaSystem_Spigot_Recode.Prefix + "The beta phase was §aenabled");
                        }
                    } else if (BetaSystem_Spigot_Recode.chinese) {
                        Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "已启用 §aBeta测试阶段");
                    } else {
                        Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "The beta phase is already §aenabled");
                    }
                }
            }
        }

        return false;
    }
}
