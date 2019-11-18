import java.util.ArrayList;

public class MainProgram {
    public static void main(String[] args) {

        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount("a",300));
        bankAccounts.add(new BankAccount("b",100));
        bankAccounts.add(new BankAccount("c",400));
        bankAccounts.add(new BankAccount("d",200));
        bankAccounts.sort(BankAccount::compareTo);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat",5));
        animals.add(new Animal("Bird", 3));
        animals.add(new Animal("Dog", 7));
        animals.add(new Animal("Mouse", 2));
        animals.sort(new AnimalComparator());


        for (BankAccount b : bankAccounts)
            System.out.println(b.getName() + " : " + b.getBalance());

        System.out.println();

        for (Animal a : animals)
            System.out.println(a.getName() + " : " + a.getAge());


    }
}
