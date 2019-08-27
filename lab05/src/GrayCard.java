public class GrayCard {
    private double balance;

    public GrayCard() {
        this.balance = 0;
    }

    public void topUp(int money) {
        if (money < 0)
            throw new IllegalArgumentException("money must be positive");
        this.balance += money;
    }

    public void spend(double purchase) {
        if (balance < purchase)
            throw new IllegalArgumentException("balance is insufficient");
        this.balance -= purchase;
    }

    @Override
    public String toString() {
        return "Balance: " + balance;
    }
}
