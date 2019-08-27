//elab-source:MasterMind.java
//elab-mainclass:MasterMind
import java.util.Scanner;

public class MasterMind {
    private String target;

    public MasterMind(String target) {
        this.target = target;
    }

    public int checkPosition(String guess) {
        int position = 0;
        for (int i=0;i<target.length();i++)
            if (target.charAt(i) == guess.charAt(i))
                position++;
        return position;
    }

    public int checkDigits(String guess) {
        int digits = 0;
        for (int i=0;i<guess.length();i++){
            for (int j=0;j<target.length();j++){
                if (target.charAt(j) == guess.charAt(i)) {
                    digits++;
                    break;
                }
            }
        } return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        MasterMind t = new MasterMind(target);
        String guess = sc.next();
        if (t.checkDigits(guess) == 4 && t.checkPosition(guess) == 4) {
            System.out.println("Congratulations, you just mastered my mind!!");
        } else {
            System.out.println(t.checkDigits(guess) + " " + t.checkPosition(guess));
        }
    }
}
