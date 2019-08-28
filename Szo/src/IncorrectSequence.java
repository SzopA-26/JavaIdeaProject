import java.util.ArrayList;
import java.util.Scanner;

public class IncorrectSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> wn = new ArrayList<>();
        ArrayList<Integer> sn = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {
            if (i < n) wn.add(sc.nextInt());
            else sn.add(sc.nextInt());
        }
        int move = 0;
        for (int i = 0; i < n; i++) {
            move++;
            while (!sn.get(i).equals(wn.get(i))) {
                int temp = wn.remove(i);
                wn.add(temp);
                move++;
            }
        }
        System.out.println(move);
    }
}
