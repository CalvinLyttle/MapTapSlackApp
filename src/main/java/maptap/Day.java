package maptap;

import java.util.ArrayList;

public class Day {
    protected Leaderboard leaderboard;
    protected ArrayList<Player> guessers;
    private String date;

    public Day(String date) {
        this.date = date;
        this.leaderboard = new Leaderboard();
        this.guessers = new ArrayList<>();
    }

    public boolean addPlayer(Player player) {
        if (guessers.contains(player)) {
            return false;
        }
        guessers.add(player);
        return true;
    }

    public void updateLeaderboard(Player player, int score) {
        leaderboard.update(player, score);
    }

    public boolean isToday() {
        String currDay = java.time.LocalDate.now().getMonth() + " "
                + java.time.LocalDate.now().getDayOfMonth();
        System.out.println("Checking if " + date + " is today (" + currDay + ")...");
        return date.equals(currDay);
    }
}
