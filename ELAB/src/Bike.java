//elab-source:Bike.java

public class Bike {
    private String licensePlate;
    private boolean available;
    private int numberOfRent;

    public Bike(String licensePlate) {
        this.licensePlate = licensePlate;
        this.available = true;
        this.numberOfRent = 0;
    }

    public void rent() {
        if (available) {
            this.numberOfRent++;
            this.available = false;
        }

    }

    public void free() {
        this.available = true;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getNumberOfRent() {
        return numberOfRent;
    }
}
