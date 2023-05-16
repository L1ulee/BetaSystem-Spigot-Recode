package listener;

import org.l1ulee.betasystemspigotrecode.BetaSystem_Spigot_Recode;

import utils.KeyManager;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class Login implements Listener{
    public Login() {
    }

    @EventHandler
    public void onJoin(PlayerLoginEvent e) {
        String UUID = e.getPlayer().getUniqueId().toString();
        if (BetaSystem_Spigot_Recode.cracked) {
            UUID = e.getPlayer().getName();
        }

        if (!KeyManager.hasBetaAccess(UUID)) {
            File file = new File("plugins//BetaSystem//config.yml");
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            if (cfg.getBoolean("BETAPHASE")) {
                e.disallow(Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', cfg.getString("KICKMSG")));
            }
        }
    }
}
