//elab-source:Car.java

public class Car {
    private double velocity;
    private double fuel;
    private double hour;
    private double maxFuel;
    private double oilConsumptionRate;
    private double distance;

    public Car(double maxFuel, double oilConsumptionRate) {
        this.maxFuel = maxFuel;
        this.oilConsumptionRate = oilConsumptionRate;
        this.hour = 0;
        this.fuel = 0;
        this.velocity = 0;
        this.distance = 0;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void addFuel(double fuel) {
        this.fuel += fuel;
        if (this.fuel > this.maxFuel)
             this.fuel = this.maxFuel;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public double getFuel() {
        return fuel;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public double getOilConsumptionRate() {
        return oilConsumptionRate;
    }

    public double getDistance() {
        return distance;
    }

    public void drive() {
        if (velocity * hour / oilConsumptionRate <= fuel) {
            fuel -= velocity * hour / oilConsumptionRate;
            distance += velocity * hour;
        } else {
            distance += fuel * oilConsumptionRate;
            fuel = 0;
            hour -= distance/velocity;
        }
    }

//    public static void main(String[] args) {
//        Car car1,car2;
//        car1 = new Car(30,60);
//        car2 = new Car(40,20);
//
//        System.out.println(car1.getDistance());
//        System.out.println(car2.getOilConsumptionRate());
//        System.out.println(car1.getMaxFuel());
//        System.out.println();
//
//        car1.setVelocity(120);
//        System.out.println(car1.getDistance());
//        System.out.println();
//
//        car1.setHour(1);
//        car1.drive();
//        System.out.println(car1.getDistance());
//        System.out.println();
//
//        car1.addFuel(50);
//        System.out.println(car1.getFuel());
//        System.out.println();
//
//        car1.setHour(1);
//        car1.drive();
//        System.out.println(car1.distance);
//        System.out.println(car1.getFuel());
//        System.out.println();
//
//        car2.addFuel(5);
//        car2.setVelocity(180);
//        car2.setHour(5);
//        car2.drive();
//        System.out.println(car2.getDistance());
//        System.out.println(car2.getFuel());
//        System.out.println();
//
//    }

}
