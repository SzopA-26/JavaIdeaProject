//elab-source:Bus.java

import java.util.ArrayList;

public class Bus {
    private String lineNumber;
    private String plateNumber;
    private ArrayList<String> driver;

    public Bus(String lineNumber, String plateNumber) {
        this.lineNumber = lineNumber;
        this.plateNumber = plateNumber;
        this.driver = new ArrayList<>();
    }

    public String toString() {
        return lineNumber + " (" + plateNumber + ")";
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getTotalDriver() {
        return driver.size();
    }

    public void drive(String driver) {
        if (!this.driver.contains(driver))
            this.driver.add(driver);
    }
}
