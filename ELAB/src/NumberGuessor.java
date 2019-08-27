//elab-source:NumberGuessor.java
//elab-mainclass:NumberGuessor

import java.util.Scanner;

public class NumberGuessor {
    private int target;

    public NumberGuessor(int target) {
        this.target = target;
    }

    public String checkTarget(int guess) {
        if (guess > target) {
            return "too high";
        } else if (guess < target) {
            return "too low";
        } else {
            return "correct";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        NumberGuessor num = new NumberGuessor(target);
        int n = sc.nextInt();
        for (int i=0 ;i <n;i++) {
            System.out.println(num.checkTarget(sc.nextInt()));
        }
    }
}
