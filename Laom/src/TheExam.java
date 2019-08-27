import java.util.Scanner;

public class TheExam {
    private String firstname;
    private String lastname;
    private double score;

    public double getScore() {
        return score;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public TheExam(String firstname, String lastname, double score){
        this.firstname = firstname;
        this.lastname = lastname;
        this.score = score;
    }

    public static void main(String[] args) {
        Scanner std = new Scanner(System.in);
        int number = std.nextInt();
        for(int i = 0; i < number; i++){
            String firstname = std.next();
            String lastname = std.next();
            double score = std.nextDouble();
        }

    }

}
