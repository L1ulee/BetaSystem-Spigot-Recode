package utils;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
public class MySQLConnect {
    public static String HOST;
    public static Integer PORT;
    public static String DATABASE;
    public static String USER;
    public static String PASSWORD;
    private Connection con;

    public MySQLConnect(String host, Integer port, String database, String user, String password) {
        HOST = host;
        PORT = port;
        DATABASE = database;
        USER = user;
        PASSWORD = password;
        this.connect();
    }
    /*测试用*/
//    public void Target(){
//        HOST = "43.248.186.42";
//        DATABASE = "minecraft_beta";
//        USER = "root";
//        PASSWORD = "HCXchengxi123";
//    }
    public void connect() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);
            Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§aThe connection with the MySQL database was successfully");
        } catch (SQLException var2) {
            Bukkit.getConsoleSender().sendMessage(BetaSystem_Spigot_Recode.Prefix + "§cThe connection with the MySQL database failed: §4" + var2.getMessage());
        }

    }

    public void close() {
        try {
            if (this.con != null) {
                this.con.close();
            }
        } catch (SQLException var2) {
        }

    }

    public void update(String qry) {
        try {
            Statement st = this.con.createStatement();
            st.executeUpdate(qry);
            st.close();
        } catch (SQLException var3) {
            this.connect();
            System.err.println(var3);
        }

    }

    public ResultSet query(String qry) {
        ResultSet rs = null;

        try {
            Statement st = this.con.createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException var4) {
            this.connect();
            System.err.println(var4);
        }

        return rs;
    }
}
