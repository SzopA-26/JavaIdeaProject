public class GreenCard extends GrayCard {
    public void topUp(int money) {
        super.topUp(money);
        if (money >= 200)
            super.topUp((int) (money / 200) *10);
    }
}
