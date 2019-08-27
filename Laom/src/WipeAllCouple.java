import java.util.Scanner;
import java.util.Stack;

public class WipeAllCouple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> stck = new Stack<>();
        for(int i = 0;i<s.length();i++) {
            if(stck.isEmpty()){
                stck.push(s.charAt(i));
            }
            else if(s.charAt(i)==stck.peek()){
                stck.pop();
            }
            else{
                stck.push(s.charAt(i));
            }
        }
        for(Character c : stck){
            System.out.print(c);
        }
    }
}
