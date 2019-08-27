import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    private String name;
    private String lastname;
    private double score;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public double getScore() {
        return score;
    }

    public Exam(String name, String lastname, double score) {
        this.name = name;
        this.lastname = lastname;
        this.score = score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Exam> stu = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String lastname = sc.next();
            double score = sc.nextDouble();
            stu.add(new Exam(name, lastname, score));
        }
        double m = sc.nextDouble();
        int count = 0;
        for (Exam i : stu) {
            if (i.getScore() >= m) {
                count++;
            }
        }
        System.out.println(count);
        for (Exam i : stu) {
            if (i.getScore() >= m) {
                System.out.println(i.getName() + " " + i.getLastname());
            }
        }

    }
}
