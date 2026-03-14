package me.server.playtimeGUI.commands;

import me.server.playtimeGUI.gui.PlaytimeMenu;
import me.server.playtimeGUI.utils.PlaytimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaytimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length == 1) {

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage("§cPlayer not found.");
                return true;
            }

            int ticks = target.getStatistic(Statistic.PLAY_ONE_MINUTE);

            player.sendMessage("§aPlaytime of §e" + target.getName() + "§7: §f" + PlaytimeUtil.formatPlaytime(ticks));

            return true;
        }

        PlaytimeMenu.open(player, 0);
        return true;
    }
}
