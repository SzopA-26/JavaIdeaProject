import java.util.ArrayList;
import java.util.Scanner;

public class MaximumProfit {

    public static int findMax (ArrayList list) {
        int m = (int)list.get(0);
        for (int i=1;i<list.size();i++) {
            if ((int)list.get(i) > m) {
                m = (int)list.get(i);
            }
        } return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList sell = new ArrayList();
        for (int i=0;i<n;i++) {
            int s = sc.nextInt();
            sell.add(s);
        }
        ArrayList profit = new ArrayList();
        for (int i=0;i<n-1;i++) {
            ArrayList pi = new ArrayList();
            for (int j=i+1;j<n;j++) {
                pi.add((int)sell.get(j) - (int)sell.get(i));
            }
            profit.add(findMax(pi));
        }
        if (findMax(profit) <= 0)
            System.out.println("No profit");
        else {
            int i=0;
            System.out.print((profit.indexOf(findMax(profit)) + 1) + " " );
            for (;;i++) {
                if ((int)sell.get(i) - (int)sell.get(profit.indexOf((findMax(profit)))) == findMax(profit)) {
                    System.out.print((i+1) + " ");
                    break;
                }
            }
            System.out.println(findMax(profit));
        }

    }
}
