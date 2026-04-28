package maptap;

import java.time.ZoneId;
import java.util.ArrayList;

public class Day {
    protected Leaderboard leaderboard;
    protected ArrayList<Player> players;
    private String date;

    public Day(String date) {
        this.date = date;
        this.leaderboard = new Leaderboard();
        this.players = new ArrayList<>();
    }

    public boolean addPlayer(Player player) {
        if (players.contains(player)) {
            return false;
        }
        players.add(player);
        return true;
    }

    public void updateLeaderboard(Player player, int score) {
        leaderboard.update(player, score);
    }

    public boolean isToday() {
        java.time.ZonedDateTime now = java.time.ZonedDateTime.now(ZoneId.of("America/New_York"));
        String currDay = now.getMonth() + " " + now.getDayOfMonth();
        System.out.println("Checking if " + date + " is today (" + currDay + ")...");
        return date.equals(currDay);
    }
}
