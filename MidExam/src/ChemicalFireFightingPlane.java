//elab-source:ChemicalFireFightingPlane.java

public class ChemicalFireFightingPlane extends FireFightingPlane {
    private char chemical;

    public ChemicalFireFightingPlane(char chemical) {
        super();
        this.chemical = chemical;
    }

    public void setChemical(char chemical) {
        this.chemical = chemical;
    }

    public void drive() {
        if (super.getWater() > 0) {
            int water = super.getWater();
            super.drive();
            for (int i=0;i<water;i++) {
                System.out.print(chemical);
            }
            System.out.println();
            super.fillWater(water);
            super.drive();
        }
    }

    public static void main(String[] args) {
        FireFightingPlane c130 = new FireFightingPlane();
        c130.fillWater(5);
        c130.drive();
        c130.fillWater(7);
        c130.drive();
        System.out.println();

        ChemicalFireFightingPlane tanker = new ChemicalFireFightingPlane('$');
        tanker.fillWater(5);
        tanker.drive();
        System.out.println();

        tanker.setChemical('+');
        tanker.fillWater(7);
        tanker.drive();
    }
}
