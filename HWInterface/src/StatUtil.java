public class StatUtil {
    public static double max(Measurable[] arrObj) {
        double max = 0;
        for (Measurable m : arrObj) {
            if (m.getMeasure() > max)
                max = m.getMeasure();
        } return max;
    }

    public static double max(Product[] arrProduct) {
        double max = 0;
        for (Product p : arrProduct) {
            if (p.getPrice() > max)
                max = p.getPrice();
        } return max;
    }

    public static double max(Car[] arrCar) {
        double max = 0;
        for (Car c : arrCar) {
            if (c.getKiloDriven() > max)
                max = c.getKiloDriven();
        } return max;
    }

}
