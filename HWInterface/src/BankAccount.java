public class BankAccount implements Comparable<BankAccount>{
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public int compareTo(BankAccount o) {
        if (this.getBalance() < o.getBalance()) return -1;
        else if (this.getBalance() > o.getBalance()) return 1;
        return 0;
    }
}
