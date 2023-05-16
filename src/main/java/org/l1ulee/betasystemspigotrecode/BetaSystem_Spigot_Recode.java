package org.l1ulee.betasystemspigotrecode;

import command.BetaSystem;
import command.DeleteAccess;
import command.DeleteKey;
import command.GiveAccess;
import command.KeyCreate;
import command.ToggleBeta;

import listener.Login;

import utils.MySQLConnect;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class BetaSystem_Spigot_Recode extends JavaPlugin {

    public static MySQLConnect mysql;
    public static boolean chinese = false;
    public static boolean cracked = false;
    public static String Prefix = "§e§lKEYS §8• §7";
    public static String NoPerms = "§e§lKEYS §8• §cYou don't have permissions to use this command";
    public static String NoPermsCN = "§e§lKEYS §8• §c你没有权限使用这个指令";
    public static String Version = "1.0-SNAPSHOT";
    public static String DevMsg = "§c本插件仅从Minecraft1.13-1.14版本移植至1.12-1.15版本，仅供测试，并非可实装版本";
    @Override
    public void onEnable() {
        // Plugin startup logic
        if (chinese) {
            Bukkit.getConsoleSender().sendMessage("§8[]===================================[]");
            Bukkit.getConsoleSender().sendMessage("§9§lBeta内测系统 §8| §7版本: §c" + Version);
            Bukkit.getConsoleSender().sendMessage("§c§l当前支持的Minecraft版本 §4§l1.12x - 1.15x");
            Bukkit.getConsoleSender().sendMessage("§7开发者: §e§lTutorialwork");
            Bukkit.getConsoleSender().sendMessage("§7重新编码 by L1ulee");
            Bukkit.getConsoleSender().sendMessage("§7开发者信息: " + DevMsg);
            Bukkit.getConsoleSender().sendMessage("§8[]===================================[]");
        } else {
            Bukkit.getConsoleSender().sendMessage("§8[]===================================[]");
            Bukkit.getConsoleSender().sendMessage("§9§lBetaSystem §8| §7Version: §c" + Version);
            Bukkit.getConsoleSender().sendMessage("§c§lDeveloped for Minecraft version §4§l1.12x - 1.15x");
            Bukkit.getConsoleSender().sendMessage("§7Developer: §e§lTutorialwork");
            Bukkit.getConsoleSender().sendMessage("§7Recoded by L1ulee");
            Bukkit.getConsoleSender().sendMessage("§7Developer Message: " + DevMsg);
            Bukkit.getConsoleSender().sendMessage("§8[]===================================[]");
        }

        this.Config();
        this.MySQL();
        this.getCommand("createkey").setExecutor(new KeyCreate());
        this.getCommand("giveaccess").setExecutor(new GiveAccess());
        this.getCommand("deletekey").setExecutor(new DeleteKey());
        this.getCommand("deleteaccess").setExecutor(new DeleteAccess());
        this.getCommand("togglebeta").setExecutor(new ToggleBeta());
        this.getCommand("betasystem").setExecutor(new BetaSystem());
        Bukkit.getPluginManager().registerEvents(new Login(), this);
    }

    private void Config() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }

        File file = new File(this.getDataFolder().getPath(), "mysql.yml");
        File config = new File(this.getDataFolder().getPath(), "config.yml");
        YamlConfiguration mysql = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration configcfg = YamlConfiguration.loadConfiguration(config);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException var9) {
                var9.printStackTrace();
            }

            mysql.options().copyDefaults(true);
            mysql.addDefault("HOST", "localhost");
            mysql.addDefault("DATABASE", "BetaSystem");
            mysql.addDefault("USER", "root");
            mysql.addDefault("PASSWORD", "yourpassword");

            try {
                mysql.save(file);
            } catch (IOException var8) {
                var8.printStackTrace();
            }
        }

        if (!config.exists()) {
            try {
                config.createNewFile();
            } catch (IOException var7) {
                var7.printStackTrace();
            }

            configcfg.options().copyDefaults(true);
            configcfg.options().header("Available languages: 简体中文 (CN) and English (EN)");
            configcfg.addDefault("LANGUAGE", "EN");
            configcfg.addDefault("BETAPHASE", true);
            configcfg.addDefault("CRACKEDMODE", false);
            configcfg.addDefault("KICKMSG", "&8[]===================================[] \n\n &7You can only join our server with a valid &c&lBetakey&7. \n\n &9Do you have a &c&lBetakey? \n&7Redeem it here: &cyourwebsite.com/beta \n\n&8[]===================================[]");

            try {
                configcfg.save(config);
            } catch (IOException var6) {
                var6.printStackTrace();
            }
        } else if (configcfg.getString("LANGUAGE").equalsIgnoreCase("CN")) {
            chinese = true;
        }

    }

    private void MySQL() {
        File file = new File(this.getDataFolder().getPath(), "mysql.yml");
        YamlConfiguration mysqlcfg = YamlConfiguration.loadConfiguration(file);
        MySQLConnect.HOST = mysqlcfg.getString("HOST");
        MySQLConnect.DATABASE = mysqlcfg.getString("DATABASE");
        MySQLConnect.USER = mysqlcfg.getString("USER");
        MySQLConnect.PASSWORD = mysqlcfg.getString("PASSWORD");
        mysql = new MySQLConnect(MySQLConnect.HOST, MySQLConnect.DATABASE, MySQLConnect.USER, MySQLConnect.PASSWORD);
        mysql.update("CREATE TABLE IF NOT EXISTS beta(\n  BETAKEY varchar(255) UNIQUE,\n  UUID varchar(255),\n  CREATOR varchar(255),\n  DATE varchar(255)\n);\n");
        File config = new File(this.getDataFolder().getPath(), "config.yml");
        YamlConfiguration configcfg = YamlConfiguration.loadConfiguration(config);
        if (configcfg.getBoolean("CRACKEDMODE")) {
            cracked = true;
        }

    }

    public static String callURL(String myURL) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;

        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60000);
            }

            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while((cp = bufferedReader.read()) != -1) {
                        sb.append((char)cp);
                    }

                    bufferedReader.close();
                }
            }

            in.close();
        } catch (Exception var7) {
            throw new RuntimeException("Exception while calling URL:" + myURL, var7);
        }

        return sb.toString();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if(chinese){
            Bukkit.getConsoleSender().sendMessage("§c插件已卸载!");
        }
        else{
            Bukkit.getConsoleSender().sendMessage("§cThe Plugin is Disabled!");
        }
    }
}
