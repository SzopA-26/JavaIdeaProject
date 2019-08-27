import java.util.Scanner;

public class BoxOfBricks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] block = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            block[i] = sc.nextInt();
            total += block[i];
        }
        int avg = total / n;
        int move = 0;
        for (int b : block) {
            if (b < avg) {
                move += avg - b;
            }
        }
        System.out.println(move);
    }
}
