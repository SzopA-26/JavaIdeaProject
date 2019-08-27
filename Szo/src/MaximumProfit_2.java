import java.util.Scanner;

public class MaximumProfit_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n];
        for (int i=0;i<n;i++) {
            profit[i] = sc.nextInt();
        } int maxProfit = 0,iProfit = 0,jProfit = 0;
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                if (profit[j] - profit[i] > maxProfit) {
                    iProfit = i+1;
                    jProfit = j+1;
                    maxProfit = profit[j] - profit[i];
                }
            }
        } if (maxProfit <= 0)
            System.out.println("No profit");
        else
            System.out.println(iProfit + " " + jProfit + " " + maxProfit);

    }
}
