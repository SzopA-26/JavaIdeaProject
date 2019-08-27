import java.util.ArrayList;
import java.util.Scanner;

public class TheExam {
    private String name;
    private String last;
    private double score;

    public TheExam(String name, String last, double score) {
        this.name = name;
        this.last = last;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getLast() {
        return last;
    }

    public double getScore() {
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<TheExam> stu = new ArrayList<TheExam>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String last = sc.next();
            double score = sc.nextDouble();
            stu.add(new TheExam(name, last, score));
        }
        n = 0;
        double score = sc.nextDouble();
        for (TheExam e : stu)
            if (e.getScore() >= score)
                n++;
        System.out.println(n);
        for (TheExam e : stu)
            if (e.getScore() >= score)
                System.out.println(e.getName() + " " + e.getLast());
    }
}
