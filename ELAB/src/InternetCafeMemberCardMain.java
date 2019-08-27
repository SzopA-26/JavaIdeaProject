// elab-source: InternetCafeMemberCardMain.java
// elab-mainclass: InternetCafeMemberCardMain
import java.util.Scanner;

public class InternetCafeMemberCardMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // member's name: Alice Bob
        Pointable memberPoint = new InternetCafeMemberCard("Alice Bob");

        // ----- add hour to member card
        // n: number of using internet cafe
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            // hour per playing
            int hour = scanner.nextInt();
            // add playing hour to card's totalHour
            memberPoint.addScore(hour);
        }
        System.out.println("Point in Card: " + memberPoint.getPoint());
        System.out.println("Card info: " + memberPoint.getInfo());

        // ----- use point
        int pointToUse = scanner.nextInt();
        memberPoint.usePoint(pointToUse);
        System.out.println("Point in Card after use: " + memberPoint.getPoint());
        System.out.println("Card info: " + memberPoint.getInfo());
    }
}

