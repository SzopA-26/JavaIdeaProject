import java.util.Scanner;
import java.util.Stack;

public class WipeAllCouples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stc = new Stack<>();
        for (char i : str.toCharArray()) {
            if (stc.empty() || (i != stc.peek()))
                stc.push(i);
            else if (i == stc.peek())
                stc.pop();
        } for (Character i : stc)
            System.out.print(i);
    }
}
