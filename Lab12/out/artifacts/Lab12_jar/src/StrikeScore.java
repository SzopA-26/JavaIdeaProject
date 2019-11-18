public class StrikeScore implements Point {
    @Override
    public double getPoint(Athlete player) {
        return player.getGames().get(0).getStrike() +
                player.getGames().get(1).getStrike() +
                player.getGames().get(2).getStrike();
    }
}
