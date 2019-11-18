public class Network {
    private String name;
    private String address;
    private double speed;

    public Network(String name, String address, double speed) {
        this.name = name;
        this.address = address;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSpeed() {
        return speed;
    }
}
