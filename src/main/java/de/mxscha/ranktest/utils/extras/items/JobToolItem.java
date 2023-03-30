package de.mxscha.ranktest.utils.extras.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class JobToolItem {

    private ItemStack tool;
    private Material material;
    private int level;

    public JobToolItem(Material material) {

    }

    public JobToolItem levelUp() {
        return this;
    }

    public void give(Player player) {

    }
}
