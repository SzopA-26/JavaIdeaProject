package Property;

public class Building implements Property{
    private double width;
    private double length;
    private int floor;

    public Building(double width, double length, int floor) {
        this.width = width;
        this.length = length;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return width*length*floor;
    }
}
