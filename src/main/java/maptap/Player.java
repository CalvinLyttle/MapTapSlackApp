package maptap;

public class Player {
    public String name;
    public int totalScore;
    public int topScore;
    public int worstScore;
    public int gamesPlayed;
    public int averageScore;

    public Player(String name) {
        this.name = name;
        this.totalScore = 0;
        this.topScore = 0;
        this.worstScore = Integer.MAX_VALUE;
        this.gamesPlayed = 0;
        this.averageScore = 0;
    }

    public int addScore(int score) {
        this.totalScore += score;
        this.topScore = Math.max(this.topScore, score);
        this.worstScore = Math.min(this.worstScore, score);
        this.gamesPlayed++;
        if (gamesPlayed == 0) {
            this.averageScore = score;
        } else {
            this.averageScore = ((this.averageScore * gamesPlayed) + score) / (gamesPlayed + 1);
        }
        this.gamesPlayed++;
        return this.topScore;
    }

    public String getStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("<@").append(this.name).append(">'s Stats");
        sb.append("\nTotal score: ").append(this.totalScore);
        sb.append("\n:gem: Best score: ").append(this.topScore);
        sb.append("\n:toilet: Worst score: ").append(this.worstScore).append("\n");
        return sb.toString();
    }
}
