public class HighScore implements Point {
    @Override
    public double getPoint(Athlete player) {
        return player.getTotalScore();
    }
}
