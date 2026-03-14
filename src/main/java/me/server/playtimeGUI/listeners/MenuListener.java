package me.server.playtimeGUI.listeners;

import me.server.playtimeGUI.gui.PlaytimeMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals("§8Player Playtime")) return;

        event.setCancelled(true);

        if (event.getCurrentItem() == null) return;

        Player player = (Player) event.getWhoClicked();

        String name = event.getCurrentItem().getItemMeta().getDisplayName();

        if (name.equals("§aNext Page")) {
            PlaytimeMenu.open(player, 1);
        }

        if (name.equals("§cPrevious Page")) {
            PlaytimeMenu.open(player, 0);
        }
    }
}
