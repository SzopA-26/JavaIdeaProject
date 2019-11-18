public class Car implements Measurable {
    private String license;
    private double kiloDriven;

    public String getLicense() {
        return license;
    }

    public double getKiloDriven() {
        return kiloDriven;
    }

    @Override
    public double getMeasure() {
        return kiloDriven;
    }
}
