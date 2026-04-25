package maptap;

public class Leaderboard {
    // can represent the leaderboard for a specific day or all time
    // needs scoreboard that allows ranking of players
    private int topScore;
    private Player topPlayer = null;
    private int secondScore;
    private Player secondPlayer = null;
    private int thirdScore;
    private Player thirdPlayer = null;

    public void update(Player player, int score) {
        if (score > topScore) {
            if (player == topPlayer) { // if player is already top player, just update score
                topScore = score;
                return;
            }
            thirdScore = secondScore;
            thirdPlayer = secondPlayer;
            secondScore = topScore;
            secondPlayer = topPlayer;
            topScore = score;
            topPlayer = player;
        } else if (score > secondScore) {
            if (player == secondPlayer) { // if player is already second player, just update score
                secondScore = score;
                return;
            }
            thirdScore = secondScore;
            thirdPlayer = secondPlayer;
            secondScore = score;
            secondPlayer = player;
        } else if (score > thirdScore) {
            if (player == thirdPlayer) { // if player is already third player, just update score
                thirdScore = score;
                return;
            }
            thirdScore = score;
            thirdPlayer = player;
        }
    }

    public String toString() {
        if (topPlayer == null) {
            return "No scores yet!";
        }
        if (secondPlayer == null) {
            return ":first_place_medal: <@" + topPlayer.name + ">: " + topScore;
        }
        if (thirdPlayer == null) {
            return ":first_place_medal: <@" + topPlayer.name + ">: " + topScore + "\n" + ":second_place_medal: <@"
                    + secondPlayer.name + ">: "
                    + secondScore;
        }
        return ":first_place_medal: <@" + topPlayer.name + ">: " + topScore + "\n" + ":second_place_medal: <@"
                + secondPlayer.name + ">: "
                + secondScore + "\n" + ":third_place_medal: <@" + thirdPlayer.name + ">: " + thirdScore;
    }
}
