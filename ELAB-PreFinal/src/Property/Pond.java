package Property;

public class Pond implements Property {
    private double radius;

    public Pond(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }
}
