package de.mxscha.ranktest.listener;

import de.mxscha.ranktest.utils.DefaultScoreboard;
import de.mxscha.ranktest.utils.PlayerTablist;
import de.mxscha.ranktest.utils.extras.Ranks;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new DefaultScoreboard(player).createScoreboard();
        // PlayerTablist.setTablist(player);
    }

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        Component msg = event.message();



        boolean rankFound = false;
        // Default chat system
        for (Ranks ranks : Ranks.values()) {
            if (player.hasPermission(ranks.getPermission()) && !rankFound) {
                rankFound = true;
                event.setCancelled(true);

                Component finalMsg = msg.color(NamedTextColor.WHITE).decoration(TextDecoration.BOLD, false);
                Component name = Component.text(player.getName()).color(NamedTextColor.GRAY).decoration(TextDecoration.BOLD, false);

                // ping a player chat System
                if (finalMsg.contains() {
                    player.sendMessage("test");
                }

                /*
                 for (Player all : Bukkit.getOnlinePlayers()) {
                    TextReplacementConfig.Builder builder = TextReplacementConfig.builder();
                    builder.match(all.getName());
                    builder.replacement(Component.text("§l@" + all.getName()).color(TextColor.fromHexString("#FB4EE9")).decorate(TextDecoration.ITALIC));

                    // Hier ist bei dem Component der Player Abgeändert
                    Component coloredName = finalMsg.replaceText(builder.build());

                    if (all != player) {
                        all.sendMessage(ranks.getPrefixForChat()
                                .append(name)
                                .append(Component.text("§8: "))
                                .append(coloredName));
                    }
                }
                 */
            }
        }

        if(!rankFound) {
            event.setCancelled(true);
            Component finalMsg = msg.color(NamedTextColor.GRAY).decoration(TextDecoration.BOLD, false);
            Component name = Component.text(player.getName()).color(NamedTextColor.GRAY).decoration(TextDecoration.BOLD, false);

            Bukkit.broadcast(Ranks.PLAYER.getPrefixForChat()
                    .append(name)
                    .append(Component.text("§8: "))
                    .append(finalMsg));
        }
    }

}
