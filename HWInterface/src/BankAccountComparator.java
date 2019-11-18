import java.util.Comparator;

public class BankAccountComparator implements Comparator<BankAccount> {

    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        if (o1.getBalance() < o2.getBalance()) return -1;
        else if (o1.getBalance() > o2.getBalance()) return 1;
        return 0;
    }
}
