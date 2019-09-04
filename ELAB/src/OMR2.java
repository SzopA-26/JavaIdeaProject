//elab-source:OMR2.java
//elab-mainclass:OMR2

import java.util.Scanner;

public class OMR2 {
    private String correct;
    private int[] score;

    public OMR2(String correct, int n) {
        this.correct = correct;
        this.score = new int[correct.length()];
    }

    public void addAnswer(String answer) {
        for (int i=0;i<correct.length();i++) {
            if (answer.charAt(i) == correct.charAt(i))
                score[i]++;
        }
    }

    public int getScore(int index) {
        return score[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correct = sc.next();
        int n = sc.nextInt();
        OMR2 test = new OMR2(correct,n);
        for (int i=0;i<n;i++)
            test.addAnswer(sc.next());
        for (int i=0;i<correct.length();i++)
            System.out.println((i+1)+": "+test.getScore(i));
    }
}
