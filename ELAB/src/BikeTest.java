import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BikeTest {
    /**
     * GIVEN I have license plate
     * WHEN I create Bike object and call getLicensePlate
     * THEN I get license plate from Bike object
     */
    @Test
    @DisplayName("getLicensePlate()")
    void testCase1() {
        Bike bike = new Bike("กข 457");
        String expected = "กข 457";
        Assertions.assertEquals(expected, bike.getLicensePlate());
    }

    /**
     * GIVEN I have an available bike object
     * WHEN a bike object is rented
     * THEN a bike is not available and increase number of rent
     */
    @Test
    @DisplayName("getNumberOfRent()")
    void testCase2() {
        Bike bike = new Bike("AB 444");
        Assertions.assertEquals(true, bike.isAvailable());
        bike.rent();
        Assertions.assertEquals(false, bike.isAvailable());
        int expected = 1;
        Assertions.assertEquals(expected, bike.getNumberOfRent());
    }

    /**
     * GIVEN I have already rented a bike
     * WHEN a bike object is rented again
     * THEN a bike could not be rented again
     */
    @Test
    @DisplayName("rent()")
    void testCase3() {
        Bike bike = new Bike("CR 797");
        bike.rent();
        int expected = 1;
        Assertions.assertEquals(expected, bike.getNumberOfRent());
        bike.rent(); // bike is not available to be rented again
        Assertions.assertEquals(expected, bike.getNumberOfRent());
    }

    /**
     * GIVEN I have already rented a bike
     * WHEN I return a bike, a bike is free
     * THEN a bike is available to rent again
     */
    @Test
    @DisplayName("free()")
    void testCase4() {
        Bike bike = new Bike("CR 797");
        bike.rent();
        int expected = 1;
        Assertions.assertEquals(expected, bike.getNumberOfRent());
        bike.free();
        bike.rent();
        expected = 2;
        Assertions.assertEquals(expected, bike.getNumberOfRent());
    }

    public static void main(String[] args) {
        BikeTest bt = new BikeTest();
        bt.testCase1();
        bt.testCase2();
        bt.testCase3();
        bt.testCase4();
    }
}