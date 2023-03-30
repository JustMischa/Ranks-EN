package de.mxscha.ranktest.utils;

import de.mxscha.ranktest.utils.extras.Ranks;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerTablist {

    public static void setTablist(Player player) {
        setPlayerList(player);
        setAllPlayersTeam();
    }

    private static void setAllPlayersTeam() {
        Bukkit.getOnlinePlayers().forEach(PlayerTablist::setPlayerTeams);
    }

    private static void setPlayerTeams(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team owner = scoreboard.getTeam("00owner");
        Team manager = scoreboard.getTeam("01manager");
        Team admin = scoreboard.getTeam("02admin");
        Team developer = scoreboard.getTeam("03developer");
        Team srmoderator = scoreboard.getTeam("04srmoderator");
        Team moderator = scoreboard.getTeam("05moderator");
        Team supporter = scoreboard.getTeam("06supporter");
        Team builder = scoreboard.getTeam("07builder");
        Team youtuberplus = scoreboard.getTeam("08youtuberplus");
        Team youtuber = scoreboard.getTeam("09youtuber");
        Team enderhacker = scoreboard.getTeam("10enderhacker");
        Team enderhero = scoreboard.getTeam("11enderhero");
        Team enderking = scoreboard.getTeam("12enderking");
        Team players = scoreboard.getTeam("13player");
        
        if (owner == null) {
            owner = scoreboard.registerNewTeam("00owner");
        }
        if (manager == null) {
            manager = scoreboard.registerNewTeam("01manager");
        }
        if (admin == null) {
            admin = scoreboard.registerNewTeam("02admin");
        }
        if (developer == null) {
            developer = scoreboard.registerNewTeam("03developer");
        }
        if (srmoderator == null) {
            srmoderator = scoreboard.registerNewTeam("04srmoderator");
        }
        if (moderator == null) {
            moderator = scoreboard.registerNewTeam("05moderator");
        }
        if (supporter == null) {
            supporter = scoreboard.registerNewTeam("06supporter");
        }
        if (builder == null) {
            builder = scoreboard.registerNewTeam("07builder");
        }
        if (youtuberplus == null) {
            youtuberplus = scoreboard.registerNewTeam("08youtuberplus");
        }
        if (youtuber == null) {
            youtuber = scoreboard.registerNewTeam("09youtuber");
        }
        if (enderhacker == null) {
            enderhacker = scoreboard.registerNewTeam("10enderhacker");
        }
        if (enderhero == null) {
            enderhero = scoreboard.registerNewTeam("11enderhero");
        }
        if (enderking == null) {
            enderking = scoreboard.registerNewTeam("12enderking");
        }
        if (players == null) {
            players = scoreboard.registerNewTeam("13player");
        }

        owner.prefix(Ranks.OWNER.getPrefixForTablist());
        manager.prefix(Ranks.MANAGER.getPrefixForTablist());
        admin.prefix(Ranks.ADMIN.getPrefixForTablist());
        developer.prefix(Ranks.DEVELOPER.getPrefixForTablist());
        srmoderator.prefix(Ranks.SRMODERATOR.getPrefixForTablist());
        moderator.prefix(Ranks.MODERATOR.getPrefixForTablist());
        supporter.prefix(Ranks.SUPPORTER.getPrefixForTablist());
        builder.prefix(Ranks.BUILDER.getPrefixForTablist());
        youtuberplus.prefix(Ranks.INFLUENCER_PLUS.getPrefixForTablist());
        youtuber.prefix(Ranks.INFLUENCER.getPrefixForTablist());
        enderhacker.prefix(Ranks.ENDERHACKER.getPrefixForTablist());
        enderhero.prefix(Ranks.ENDERHERO.getPrefixForTablist());
        enderking.prefix(Ranks.ENDERKING.getPrefixForTablist());
        players.prefix(Ranks.PLAYER.getPrefixForTablist());

        owner.color(NamedTextColor.GRAY);
        manager.color(NamedTextColor.GRAY);
        admin.color(NamedTextColor.GRAY);
        developer.color(NamedTextColor.GRAY);
        srmoderator.color(NamedTextColor.GRAY);
        moderator.color(NamedTextColor.GRAY);
        supporter.color(NamedTextColor.GRAY);
        builder.color(NamedTextColor.GRAY);
        youtuberplus.color(NamedTextColor.GRAY);
        youtuber.color(NamedTextColor.GRAY);
        enderhacker.color(NamedTextColor.GRAY);
        enderhero.color(NamedTextColor.GRAY);
        enderking.color(NamedTextColor.GRAY);
        players.color(NamedTextColor.GRAY);

        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.hasPermission(Ranks.OWNER.getPermission())) {
                owner.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.MANAGER.getPermission())) {
                manager.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.ADMIN.getPermission())) {
                admin.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.DEVELOPER.getPermission())) {
                developer.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.SRMODERATOR.getPermission())) {
                srmoderator.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.MODERATOR.getPermission())) {
                moderator.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.SUPPORTER.getPermission())) {
                supporter.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.BUILDER.getPermission())) {
                builder.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.INFLUENCER_PLUS.getPermission())) {
                youtuberplus.addEntry(target.getName());
                continue;
            } if (target.hasPermission(Ranks.INFLUENCER.getPermission())) {
                youtuber.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.ENDERHACKER.getPermission())) {
                enderhacker.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.ENDERHERO.getPermission())) {
                enderhero.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.ENDERKING.getPermission())) {
                enderking.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission(Ranks.PLAYER.getPermission())) {
                players.addEntry(target.getName());
                continue;
            }
            players.addEntry(target.getName());
        }
    }

    private static void setPlayerList(Player player) {
        player.setPlayerListHeader("");
        player.setPlayerListFooter("");
    }
}
