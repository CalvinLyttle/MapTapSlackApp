package maptap;

import java.util.HashMap;

public class Tapbot {

    private HashMap<String, Day> days;
    private HashMap<String, Player> players;
    private Leaderboard allTimeLeaderboard;
    private Day today;

    public Tapbot() {
        this.days = new HashMap<>();
        this.players = new HashMap<>();
        this.allTimeLeaderboard = new Leaderboard();
    }

    public void addMsg(String body, String name) {
        Message msg = new Message(body, name);
        today = days.get(msg.date);
        if (today == null) {
            today = new Day(msg.date);
            days.put(msg.date, today);
        }
        Player player = players.get(msg.name);
        if (player == null) {
            player = new Player(msg.name);
            players.put(msg.name, player);
        }
        if (!today.addPlayer(player)) { // check if player has already sent today's score
            return;
        }
        player.addScore(msg.score);
        today.updateLeaderboard(player, msg.score);
        allTimeLeaderboard.update(player, player.totalScore);
    }

    public String endOfDay() {
        String currDay = java.time.LocalDate.now().getMonth() + " "
                + java.time.LocalDate.now().getDayOfMonth();
        if (!today.isToday()) {
            today = days.get(currDay);
        }
        if (today == null) {
            return "No scores for today, " + currDay + "!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Today's leaderboard:\n");
        sb.append(today.leaderboard.toString()).append("\n\n");
        sb.append("All time leaderboard:\n");
        sb.append(allTimeLeaderboard.toString());
        return sb.toString();
    }
}
