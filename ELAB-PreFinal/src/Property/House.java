package Property;

public class House implements Property {
    private double sqWa;

    public House(double sqWa) {
        this.sqWa = sqWa;
    }

    @Override
    public double getArea() {
        return sqWa*4;
    }
}
