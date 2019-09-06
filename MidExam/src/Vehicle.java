//elab-source:Vehicle.java

public class Vehicle {
    private double distance;
    private double capacity;

    public Vehicle() {
        this.distance = 0;
        this.capacity = 0;
    }

    public void move(double distance) {
        this.distance += distance;
    }

    public void add(double capacity) {
        this.capacity += capacity;
    }

    public void remove(double capacity) {
        this.capacity -= capacity;
    }

    public double getDistance() {
        return distance;
    }

    public double getCapacity() {
        return capacity;
    }
}
