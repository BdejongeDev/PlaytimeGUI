package me.server.playtimeGUI.utils;

public class PlaytimeUtil {

    public static String formatPlaytime(int ticks) {

        long seconds = ticks / 20;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        minutes = minutes % 60;

        return hours + "h " + minutes + "m";
    }
}
