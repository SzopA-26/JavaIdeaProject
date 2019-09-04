//elab-source:OMR.java
//elab-mainclass:OMR

import java.util.Scanner;

public class OMR {
    private String correct;

    public OMR(String correct) {
        this.correct = correct;
    }

    public int getScore(String answer) {
        int s = 0;
        for (int i=0;i<correct.length();i++){
            if (answer.charAt(i) == correct.charAt(i))
                s++;
        }
        return s;
    }

    public int getMaxScore() {
        return correct.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OMR test = new OMR(sc.next());
        int n = sc.nextInt();
        String stu[] = new String[n];
        double totalSC = 0;
        for (int i=0;i<n;i++)
            stu[i] = sc.next();
        for (int i=0;i<n;i++) {
            System.out.println((i + 1) + ": " + test.getScore(stu[i]) + "/" + test.getMaxScore());
            totalSC += test.getScore(stu[i]);
        }
        System.out.println("Average: "+ totalSC/n);
    }
}
