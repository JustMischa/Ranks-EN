package de.mxscha.ranktest.cmds;

import de.mxscha.ranktest.utils.extras.items.JobToolItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LevelUpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            if (!(itemStack.getType() == Material.AIR)) {
                new JobToolItem(itemStack.getType(), itemStack.getItemMeta().displayName()).addLevel()
                                .replacePlayers(player, player.getInventory().getHeldItemSlot());
                player.sendMessage("§aDu hast dein Tool heraufgestuft.");
            } else
                player.sendMessage("§cBitte nimm dein Tool in die Hand!");
        }
        return false;
    }
}
