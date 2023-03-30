package de.mxscha.ranktest.utils.extras.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class JobToolItem {

    private final ItemStack tool;
    private final int level;

    public JobToolItem(Material material, String displayName) {
        level = 1;
        tool = new ItemCreator(material)
                .setName(displayName)
                .setLore("§8» §7Level§8: §b" + level)
                .toItemStack();
    }

    public JobToolItem setDefaultEnchantment(Enchantment enchantment, int tier) {
        ItemMeta meta = tool.getItemMeta();
        meta.addEnchant(enchantment, tier, true);
        return this;
    }

    public JobToolItem setLevel(int level) {
        ItemMeta meta = tool.getItemMeta();
        meta.lore(Collections.singletonList(Component.text("§8» §7Level§8: §b" + level)));
        return this;
    }

    public JobToolItem setLevel(Material material, int level) {
        ItemMeta meta = tool.getItemMeta();
        tool.setType(material);
        meta.lore(Collections.singletonList(Component.text("§8» §7Level§8: §b" + level)));
        return this;
    }

    public JobToolItem setLevel(Material material, int level, Enchantment enchantment, int tier) {
        ItemMeta meta = tool.getItemMeta();
        tool.setType(material);
        meta.addEnchant(enchantment, tier, true);
        meta.lore(Collections.singletonList(Component.text("§8» §7Level§8: §b" + level)));
        return this;
    }

    public int getLevel() {
        return level;
    }

    public void givePlayer(Player player) {
        player.getInventory().addItem(tool);
    }
}
