package de.mxscha.ranktest;

import de.mxscha.ranktest.cmds.LevelUpCommand;
import de.mxscha.ranktest.listener.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RankTest extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChatListener(), this);

        getCommand("lvlup").setExecutor(new LevelUpCommand());
    }

    @Override
    public void onDisable() {

    }
}
