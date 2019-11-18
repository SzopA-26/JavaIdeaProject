package Property;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalArea = 0;
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String propertyType = sc.next();
            Property property;
            if (propertyType.equals("Property.House"))
                property = new House(sc.nextDouble());
            else if (propertyType.equals("Property.Building"))
                property = new Building(sc.nextDouble(), sc.nextDouble(), sc.nextInt());
            else property = new Pond(sc.nextDouble());
            totalArea += property.getArea();
        }

        System.out.format("%.2f\n", totalArea);
    }
}
