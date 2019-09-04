//elab-source:MemberCard.java

public class MemberCard {
    private String name;
    private int numberOfRent;
    private Bike bike;

    public MemberCard(String name) {
        this.name = name;
        this.numberOfRent = 0;
        this.bike = null;
    }

    public void rentBike(Bike bike) {
        if (this.bike == null && bike.isAvailable()) {
            this.bike = bike;
            this.numberOfRent++;
            bike.rent();
        }
    }

    public String viewBikeLicensePlate() {
        if (bike == null)
            return "";
        else return bike.getLicensePlate();
    }

    public void returnBike() {
        if (bike != null) {
            this.bike.free();
            this.bike = null;
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRent() {
        return numberOfRent;
    }
}
