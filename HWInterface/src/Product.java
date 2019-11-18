public class Product implements Measurable{
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double getMeasure() {
        return price;
    }
}
