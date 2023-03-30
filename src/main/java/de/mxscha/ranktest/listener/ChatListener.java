package de.mxscha.ranktest.listener;

import de.mxscha.ranktest.utils.DefaultScoreboard;
import de.mxscha.ranktest.utils.extras.Ranks;
import de.mxscha.ranktest.utils.extras.items.JobToolItem;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new DefaultScoreboard(player).createScoreboard();
        // PlayerTablist.setTablist(player);
        new JobToolItem(Material.GOLDEN_SWORD, "§cTest Tool").givePlayer(player);
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

                // play the player a sound
                String msgString = PlainTextComponentSerializer.plainText().serialize(finalMsg);

                TextReplacementConfig.Builder chatMessage = TextReplacementConfig.builder();


                // Pattern = Woran wir suchen
                Pattern pattern = Pattern.compile("@[a-zA-Z0-9_.]*");

                Matcher matcher = pattern.matcher(msgString);
                while (matcher.find()) {
                    String currentMatch = matcher.group();
                    String currentPlayer = currentMatch.substring(1);

                    // replace the player name with the ping
                    chatMessage.match(currentMatch);
                    chatMessage.replacement(Component.text(currentMatch).color(TextColor.fromHexString("#FB4EE9")).decorate(TextDecoration.ITALIC));

                    // ping the other player
                    Bukkit.getOnlinePlayers().forEach(all -> {
                        if (all.getName().equalsIgnoreCase(currentPlayer)) {
                            all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
                        }

                        // Hier wird die Nachricht an den Spieler gesendet
                        all.sendMessage(ranks.getPrefixForChat()
                                .append(name)
                                .append(Component.text("§8: "))
                                .append(finalMsg.replaceText(chatMessage.build())));
                    });
                }
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
