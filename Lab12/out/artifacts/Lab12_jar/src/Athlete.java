import java.util.ArrayList;

public class Athlete {
    private String name;
    private ArrayList<BowlingScores> games;
    private int totalScore;

    public Athlete(String name) {
        this.name = name;
        this.games = new ArrayList<>();
        this.totalScore = 0;
    }

    public void addScores(BowlingScores scores) {
        games.add(scores);
        totalScore += scores.getTotalScore();
    }

    public String getName() {
        return name;
    }

    public ArrayList<BowlingScores> getGames() {
        return games;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
