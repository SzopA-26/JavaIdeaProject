//elab-source:Hangman.java
//elab-mainclass:Hangman
import java.util.Scanner;

public class Hangman {
    private String target;
    private char[] guess;
    private int life = 6;
    private boolean correct = false;

    public Hangman (String target) {
        this.target = target;
        this.guess = new char[target.length()];
        for(int i=0;i<target.length();i++)
            guess[i] = '-';
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(life);
        str.append(" ");
        for (char a : guess) {
            str.append(a);
        }
        return str.toString();

    }

    public int getLife() {
        return life;
    }

    public String getTarget() {
        return target;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void addGuess (char g) {
        boolean check = true;
        for (int i=0;i<target.length();i++) {
            if (target.charAt(i) == g) {
                guess[i] = g;
                check = false;
                if (target.equals(toString().substring(2)))
                    correct = true;
            }
        } if (check) {
            life--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        Hangman hm = new Hangman(target);
        System.out.println(hm.toString());
        while (true) {
            char g = sc.next().charAt(0);
            hm.addGuess(g);
            System.out.println(hm.toString());
            if (hm.getLife() <= 0 || hm.isCorrect())
                break;
        } if (hm.isCorrect())
            System.out.println("Congratulations, you win");
        else System.out.println("You lose, the answer is " + hm.getTarget());
    }
}
