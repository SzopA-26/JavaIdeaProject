//elab-source:InternetCafeMemberCard.java
public class InternetCafeMemberCard implements Pointable{
    private String name;
    private double totalScore;
    private int point;

    public InternetCafeMemberCard(String name) {
        this.name = name;
        this.totalScore = 0;
        this.point = 0;
    }

    @Override
    public void addScore(double score) {
        this.totalScore += score;
        this.point += (int)score/2;
    }

    @Override
    public void usePoint(int score) {
        if (score <= this.point) {
            this.point -= score;
        }
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public String getInfo() {
        return "InternetCafeMemberCard{name='" + name + "', totalHour="
                + (int)totalScore + ", point=" + point + "}";
    }
}
