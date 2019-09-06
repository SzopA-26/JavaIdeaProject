//elab-source:FireFightingPlane.java

public class FireFightingPlane {
    private int water;
    private char chemical;

    public FireFightingPlane() {
        this.water = 0;
        this.chemical = '*';
    }

    public void fillWater(int water) {
        this.water += water;
    }

    public void drive() {
        if (getWater() > 0) {
            for (int i=0;i<water;i++) {
                System.out.print(chemical);
            }
            System.out.println();
            this.water = 0;
        }
    }

    public int getWater() {
        return water;
    }
}
