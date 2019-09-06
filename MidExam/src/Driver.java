//elab-source:Driver.java

import java.util.ArrayList;

public class Driver {
    private String name;
    private int totalDrive;
    private Bus bus;
    private ArrayList<String> busDriven;

    public Driver(String name) {
        this.name = name;
        this.totalDrive = 0;
        this.bus = null;
        this.busDriven = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void drive() {
        if (this.bus != null) {
            if (!busDriven.contains(bus.getLineNumber()))
                busDriven.add(bus.getLineNumber());
            this.bus.drive(name);
            this.bus = null;
            this.totalDrive++;
        }
    }

    public int getTotalDrive() {
        return totalDrive;
    }

    public boolean hasDriven(String busLine) {
        if (busDriven.contains(busLine))
            return true;
        else return false;
    }

//    public static void main(String[] args) {
//        Bus bus24, bus34A, bus34B;
//        Driver d1, d2, d3;
//
//        bus24 = new Bus("24","5ข 1433");
//        bus34A = new Bus("34A","6ง 8930");
//        bus34B = new Bus("34B","อฟ 62");
//        d1 = new Driver("Somsak");
//        d2 = new Driver("Preeyanut");
//        d3 = new Driver("Rachen");
//
////        System.out.println(bus34B);
////        System.out.println(bus24.getLineNumber());
////        System.out.println(bus34A.getPlateNumber() + "\n");
////
////        d1.setBus(bus24);
////        d1.drive();
////        d1.setBus(bus34A);
////        d1.drive();
////        d2.setBus(bus34A);
////        d2.drive();
////        d3.setBus(bus34B);
////        d3.drive();
////        d1.setBus(bus24);
////        d1.drive();
////        d2.setBus(bus34A);
////        d2.drive();
////
////        System.out.println(bus24.getTotalDriver());
////        System.out.println(bus34A.getTotalDriver()+"\n");
////
////        System.out.println(d1.getTotalDrive());
////        System.out.println(d3.hasDriven("24"));
//
////        d1.setBus(bus24);
////        d1.setBus(bus24);
////        System.out.println(d1.hasDriven(bus24.getLineNumber()));
//
//    }
}
