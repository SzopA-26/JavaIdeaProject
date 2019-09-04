import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberCardTest {
    /**
     * GIVEN I have a member card
     * WHEN I do nothing
     * THEN I have no bike
     */
    @Test
    @DisplayName("getName()")
    void testCase1() {
        MemberCard card = new MemberCard("Persona One");
        String expected = "Persona One";
        Assertions.assertEquals(expected, card.getName());
        Assertions.assertEquals("", card.viewBikeLicensePlate());
    }

    /**
     * GIVEN I have a member card
     * WHEN I rent a bike
     * THEN I can view a bike's license plate
     */
    @Test
    @DisplayName("viewBikeLicensePlate()")
    void testCase2() {
        MemberCard card = new MemberCard("Persona Two");
        Bike bike1 = new Bike("B1");
        card.rentBike(bike1);
        Assertions.assertEquals("B1", card.viewBikeLicensePlate());
        Assertions.assertEquals(1, card.getNumberOfRent());
    }

    /**
     * GIVEN I have already rented a bike
     * WHEN I rent another bike
     * THEN I could not rent more bike
     */
    @Test
    @DisplayName("getNumberOfRent()")
    void testCase3() {
        MemberCard card = new MemberCard("Personal Three");
        Bike bike1 = new Bike("AA 88");
        Bike bike2 = new Bike("JL 914");
        card.rentBike(bike1);
        card.rentBike(bike2);
        Assertions.assertEquals("AA 88", card.viewBikeLicensePlate());
        Assertions.assertEquals(1, card.getNumberOfRent());
    }

    /**
     * GIVEN I have already rented a bike
     * WHEN I return a bike
     * THEN I can rent another bike
     */
    @Test
    @DisplayName("returnBike()")
    void testCase4() {
        MemberCard card = new MemberCard("Personal Four");
        Bike bike1 = new Bike("BIKE 1");
        Bike bike2 = new Bike("BIKE 2");
        card.rentBike(bike1);
        card.returnBike();
        card.rentBike(bike2);
        Assertions.assertEquals("BIKE 2", card.viewBikeLicensePlate());
        Assertions.assertEquals(2, card.getNumberOfRent());
    }

    public static void main(String[] args) {
        MemberCardTest mt = new MemberCardTest();
        mt.testCase1();
        mt.testCase2();
        mt.testCase3();
        mt.testCase4();
    }
}