import java.util.ArrayList;
import java.util.Scanner;

public class Travel {
    private String name;
    private ArrayList<Travel> connect;
    private boolean passed;

    public Travel(String name) {
        this.name = name;
        connect = new ArrayList<>();
        passed = false;
    }

    public void addConnect(Travel travel) {
        connect.add(travel);
        travel.connect.add(this);
    }

    public boolean canFindTravel(Travel travel) {
        for (Travel c : connect) {
            if (c == travel)
                return true;
            else if (!c.passed) {
                c.passed = true;
                if (c.canFindTravel(travel))
                    return true;
            }
        } return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nTravel = sc.nextInt();
        int nConnect = sc.nextInt();
        Travel[] travels = new Travel[nTravel];
        for (int i=0;i<nTravel;i++) {
            travels[i] = new Travel(i+"");
        }
        for (int i=0;i<nConnect;i++) {
            int sTravel = sc.nextInt();
            int eTravel = sc.nextInt();
            travels[sTravel].addConnect(travels[eTravel]);
        }
        int startTravel = sc.nextInt();
        int endTravel = sc.nextInt();
        if (travels[startTravel].canFindTravel(travels[endTravel])) {
            System.out.println("go go!");
        } else
            System.out.println("stay home");
    }
}
