public class WeightScore implements Point {
    private double[] weightScore = new double[3];

    public WeightScore(double w1, double w2, double w3) {
        weightScore[0] = w1;
        weightScore[1] = w2;
        weightScore[2] = w3;
    }

    @Override
    public double getPoint(Athlete player) {
        return (player.getGames().get(0).getTotalScore()/100*weightScore[0]) +
                (player.getGames().get(1).getTotalScore()/100*weightScore[1]) +
                (player.getGames().get(2).getTotalScore()/100*weightScore[2]);
    }
}
