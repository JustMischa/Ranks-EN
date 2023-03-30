package de.mxscha.ranktest.utils;

import de.mxscha.ranktest.utils.extras.Ranks;
import de.mxscha.ranktest.utils.extras.ScoreboardBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class DefaultScoreboard extends ScoreboardBuilder {

    private int id;

    public DefaultScoreboard(Player player) {
        super(player, "       "+ "§6§lTest" + "       ");
        this.id = 0;
        PlayerTablist.setTablist(player);
    }

    public void createScoreboard() {
        setScore("§8§m                               ", 10);
        setScore("§a", 7);
        setScore("§8● §7Dein Geld§8:", 6);
        DecimalFormat f = new DecimalFormat("#0.00");
        // setScore("  §8» §a" + f.format(EndoflifeCore.getInstance().getMoneyAPI().getMoney(player)) + "€", 5);
        setScore("§b", 4);
        setScore("§a§8§m                               ", 1);
        update();
    }

    public void update() {
        setScore("§8§m                               ", 10);
        setScore("§8● §7Dein Rang§8:", 9);

        boolean rankFound = false;
        // Default chat system
        for (Ranks ranks : Ranks.values()) {
            if (player.hasPermission(ranks.getPermission()) && !rankFound) {
                rankFound = true;
                setScore("  §8» " + ranks.getPrefix(), 8);
            }
        }

        if(!rankFound) {
            setScore("  §8» " + Ranks.PLAYER.getPrefix(), 8);
        }
        setScore("§a", 7);
        setScore("§8● §7Dein Geld§8:", 6);
        setScore("§a§8§m                               ", 1);
    }
}
