package me.server.playtimeGUI.gui;

import me.server.playtimeGUI.utils.PlaytimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class PlaytimeMenu {

    public static void open(Player player, int page) {

        Inventory inv = Bukkit.createInventory(null, 54, "§8Player Playtime");

        List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());

        int start = page * 45;
        int end = Math.min(start + 45, players.size());

        for (int i = start; i < end; i++) {

            Player target = players.get(i);

            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) head.getItemMeta();

            meta.setOwningPlayer(target);
            meta.setDisplayName("§e" + target.getName());

            int ticks = target.getStatistic(Statistic.PLAY_ONE_MINUTE);

            List<String> lore = new ArrayList<>();
            lore.add("§7Playtime:");
            lore.add("§a" + PlaytimeUtil.formatPlaytime(ticks));

            meta.setLore(lore);

            head.setItemMeta(meta);

            inv.addItem(head);
        }

        ItemStack previous = new ItemStack(Material.ARROW);
        ItemMeta prevMeta = previous.getItemMeta();
        prevMeta.setDisplayName("§cPrevious Page");
        previous.setItemMeta(prevMeta);

        ItemStack next = new ItemStack(Material.ARROW);
        ItemMeta nextMeta = next.getItemMeta();
        nextMeta.setDisplayName("§aNext Page");
        next.setItemMeta(nextMeta);

        inv.setItem(45, previous);
        inv.setItem(53, next);

        player.openInventory(inv);
    }
}
