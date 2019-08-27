// elab-source: MemberCardMain.java
// elab-mainclass: MemberCardMain
import java.util.Scanner;

public class MemberCardMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // member's name: Alice Bob
        Pointable memberPoint = new MemberCard("Alice Bob");

        // ----- add product's prices to member card
        // n: number of products to purchase
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            // each product's price
            double price = scanner.nextDouble();
            // add price to MemberCard's totalPurchase
            memberPoint.addScore(price);
        }
        System.out.println("Point in MemberCard: " + memberPoint.getPoint());
        System.out.println("MemberCard info: " + memberPoint.getInfo());

        // ----- use point
        int pointToUse = scanner.nextInt();
        memberPoint.usePoint(pointToUse);
        System.out.println("Point in MemberCard after use: " + memberPoint.getPoint());
        System.out.println("MemberCard info: " + memberPoint.getInfo());
    }
}