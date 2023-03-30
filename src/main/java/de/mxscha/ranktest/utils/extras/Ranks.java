package de.mxscha.ranktest.utils.extras;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.md_5.bungee.api.ChatColor;

public enum Ranks {

    /*
        Rank Class coded for EnderNation
        Made by: Mxscha (+KeksGauner)

        How to add a rank:
            TEST_RANK("[Prefix], NamedTextColor.[WantedColor], "[permission]");

        How to add a rank with 2 colors:
            TEST_RANK("[Prefix1]","[Prefix2], NamedTextColor.[ColorForPrefix2], NamedTextColor.[ColorForPrefix1], "[permission]");
     */

    OWNER("Owner", NamedTextColor.DARK_RED, "rang.owner"),
    MANAGER("Manger", NamedTextColor.RED, "rang.manager"),
    ADMIN("Admin", NamedTextColor.RED, "rang.admin"),
    SRDEVELOPER("SrDeveloper", NamedTextColor.AQUA, "rang.srdeveloper"),
    DEVELOPER("Developer", NamedTextColor.AQUA, "rang.developer"),
    SRMODERATOR("Sr", "Moderator", NamedTextColor.DARK_PURPLE, NamedTextColor.RED, "rang.srmoderator"),
    MODERATOR("Moderator", NamedTextColor.DARK_PURPLE, "rang.moderator"),
    SUPPORTER("Supporter", NamedTextColor.YELLOW, "rang.supporter"),
    BUILDER("Builder", NamedTextColor.DARK_BLUE, "rang.developer"),
    INFLUENCER_PLUS("Influencer", "+", NamedTextColor.LIGHT_PURPLE, NamedTextColor.DARK_PURPLE,"rang.youtuberplus"),
    INFLUENCER("Influencer", NamedTextColor.DARK_PURPLE, "rang.youtuber"),
    ENDERHACKER("Ender", "Hacker", NamedTextColor.AQUA, NamedTextColor.DARK_AQUA, "rang.enderhacker"),
    ENDERHERO("Ender", "Hero", NamedTextColor.DARK_GREEN, NamedTextColor.DARK_AQUA, "rang.enderhero"),
    ENDERKING("Ender", "King", NamedTextColor.GOLD, NamedTextColor.DARK_AQUA, "rang.enderking"),
    PLAYER("Beta", NamedTextColor.LIGHT_PURPLE, "rang.spieler");

    private final String prePrefix;
    private final String prefix;
    private final TextColor color;
    private final TextColor secondColor;
    private final String permission;

    Ranks(String prePrefix, String prefix, TextColor color, TextColor secondColor, String permission) {
        this.prePrefix = prePrefix;
        this.prefix = prefix;
        this.color = color;
        this.secondColor = secondColor;
        this.permission = permission;
    }

    Ranks(String prefix, TextColor color, String permission) {
        this.prefix = prefix;
        this.color = color;
        this.permission = permission;
        secondColor = null;
        prePrefix = null;
    }
    

    public String getPrefix() {
        if (secondColor == null || prePrefix == null) {
            return  ChatColor.of(color.asHexString()) + "§l" + prefix;
        } else {
            // prePrefix = Ender(secondColor), Prefix = Hero(color)
            return org.bukkit.ChatColor.getByChar(secondColor.asHexString()) + "§l" +  prePrefix +
                    ChatColor.of(color.asHexString()) + "§l" + prefix;
        }

    }

    public String getPermission() {
        return permission;
    }

    public TextColor getColor() {
        return color;
    }

    public Component getPrefixForChat() {
        if (secondColor == null || prePrefix == null) {
            return Component.text(prefix).color(color).decorate(TextDecoration.BOLD)
                    .append(Component.text(" §8» "));
        } else {
            // prePrefix = Ender(secondColor), Prefix = Hero(color)
            return Component.text(prePrefix).color(secondColor).decorate(TextDecoration.BOLD)
                        .append(Component.text(prefix).color(color).decorate(TextDecoration.BOLD)
                                .append(Component.text(" §8» ")));
        }
    }

    public Component getPrefixForTablist() {
        if (secondColor == null || prePrefix == null) {
            return Component.text(prefix).color(color).decorate(TextDecoration.BOLD)
                    .append(Component.text(" §8» "));
        } else {
            // prePrefix = Ender(secondColor), Prefix = Hero(color)
            return Component.text(prePrefix).color(secondColor).decorate(TextDecoration.BOLD)
                    .append(Component.text(prefix).color(color).decorate(TextDecoration.BOLD)
                            .append(Component.text(" §8» ")));
        }
    }
}
