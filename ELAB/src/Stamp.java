//elab-source:Stamp.java
//elab-mainclass:Stamp

import java.util.Scanner;
public class Stamp {
    private double purchase;

    public Stamp () {
        this.purchase = 0;
    }

    public void addStamp(double purchase) {
        this.purchase += purchase;
    }

    public int getStamp() {
        return (int)purchase/50;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stamp s = new Stamp();
        for (int i=0;i<n;i++) {
            s.addStamp(sc.nextDouble());
        }
        System.out.println(s.getStamp());

    }
}
