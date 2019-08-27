import java.util.Scanner;
import java.util.Stack;

public class GameCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        Stack[] stc = new Stack[c];
        for (int i=0; i<n; i++) {
            stc[i] = new Stack<Integer>();
            for (int j=0; j<c; j++) {
                String input = sc.next();
                if (input.equals("C") && !stc[i].isEmpty())
                    stc[i].pop();
                else if (input.equals("D") && !stc[i].isEmpty())
                    stc[i].push((int) stc[i].peek() * 2);
                else if (input.equals("+") && !stc[i].isEmpty()) {
                    int temp = (int) stc[i].pop();
                    int tempS = temp + (int) stc[i].peek();
                    stc[i].push(temp);
                    stc[i].push(tempS);
                } else
                    stc[i].push(Integer.valueOf(input));
            }
        }
        int score = 0;
        for (int i=0;i<n;i++) {
            while (!stc[i].isEmpty())
                score += (int)stc[i].pop();
            System.out.print(score + " ");
            score = 0;
        }
    }
}
