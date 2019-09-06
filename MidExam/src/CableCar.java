//elab-source:CableCar.java

import java.util.ArrayList;

public class CableCar {
    private int capacity;
    private int maxCapacity;
    private double weight;
    private double maxWeight;
    private ArrayList<Passenger> passengers;


    public CableCar(int capacity, double weight) {
        this.maxCapacity = capacity;
        this.maxWeight = weight;
        this.passengers = new ArrayList<>();
    }

    public double getWeight() {
        return weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void pickUp(Passenger passenger) {
        if (passenger.getWeight() + this.weight <= this.maxWeight && this.capacity + 1 <= this.maxCapacity) {
            this.passengers.add(passenger);
            this.weight += passenger.getWeight();
            this.capacity += 1;
        }
    }

    public void drive() {
        String s = "";
        if (this.passengers.size() > 0) {
            while (this.passengers.size() > 0) {
                s += passengers.get(0).getName() + " ";
                passengers.remove(0);
            }
            this.weight = 0;
            this.capacity = 0;
        }System.out.println(s);
    }

    public static void main(String[] args) {
        CableCar cableCar;
        Passenger jumbo, nook, tonmai;

        cableCar = new CableCar(3, 100);
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity() + "\n");

        jumbo = new Passenger("Jumbo",45.5);
        nook = new Passenger("Nook",54.4);
        tonmai = new Passenger("Tonmai",78);

        cableCar.pickUp(jumbo);
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity() + "\n");

        cableCar.pickUp(nook);
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity() + "\n");

        cableCar.pickUp(tonmai);
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity() + "\n");

        cableCar.drive();
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.capacity);
    }
}
