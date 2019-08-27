//elab-source:MemberCard.java
public class MemberCard implements Pointable {
    private String name;
    private int point;
    private double score;

    public MemberCard(String name) {
        this.name = name;
        this.point = 0;
        this.score = 0;
    }

    @Override
    public void addScore(double score) {
        this.score += score;
        this.point = (int)this.score/250;
    }

    @Override
    public void usePoint(int point) {
        if (point <= this.point)
            this.point -= point;
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public String getInfo() {
        return "MemberCard{name='" + name + "', totalPurchase=" + score + ", point=" + point + "}";
    }
}
