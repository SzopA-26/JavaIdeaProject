public class BowlingScores {
    private int[] scores;
    private double totalScore;
    private int strike;
    private int round;

    public BowlingScores() {
        this.scores = new int[10];
        this.round = 0;
        this.strike = 0;
        this.totalScore = 0;
    }

    public void addScores(int score1, int score2) {
        scores[round] = score1 + score2;
        totalScore += scores[round];
        if (score1 == 10)
            strike++;
        round++;
    }

    public int getStrike() {
        return strike;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public int getRound() {
        return round;
    }
}
