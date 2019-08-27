public class BlueCard extends GrayCard {
    private int point;

    public BlueCard() {
        super();
        this.point = 0;
    }

    public void topUp(int money) {
        super.topUp(money);
        if (money >= 200)
            point += (money / 200) * 10;
    }

    public void spend(double purchase) {
        super.spend(purchase);
        if (purchase >= 50)
            point += (int) (purchase / 50) * 2;
    }

    public void usePoint(int point) {
        if (this.point < point)
            throw new IllegalArgumentException("point is insufficient");
        this.point -= point;
    }

    @Override
    public String toString() {
        return super.toString() + " Point: " + point;
    }
}
