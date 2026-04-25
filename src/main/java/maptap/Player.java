package maptap;

public class Player {
    public String name;
    public int totalScore;
    public int topScore;
    public int worstScore;

    public Player(String name) {
        this.name = name;
        this.totalScore = 0;
        this.topScore = 0;
        this.worstScore = Integer.MAX_VALUE;
    }

    public int addScore(int score) {
        this.totalScore += score;
        this.topScore = Math.max(this.topScore, score);
        this.worstScore = Math.min(this.worstScore, score);
        return this.topScore;
    }
}
