public class MainProgram {
    public static void main(String[] args) {
        GrayCard grayCard = new GrayCard();
        GreenCard greenCard = new GreenCard();
        BlueCard blueCard = new BlueCard();

        grayCard.topUp(400);
        greenCard.topUp(400);
        blueCard.topUp(400);

        System.out.println("Gray " + grayCard.toString());
        System.out.println("Green " + greenCard.toString());
        System.out.println("Blue " + blueCard.toString());
        System.out.println("---------------");

        grayCard.spend(200);
        greenCard.spend(200);
        blueCard.spend(200);

        System.out.println("Gray " + grayCard.toString());
        System.out.println("Green " + greenCard.toString());
        System.out.println("Blue " + blueCard.toString());
        System.out.println("---------------");

        blueCard.usePoint(20);
        System.out.println("Blue " + blueCard.toString());
    }
}