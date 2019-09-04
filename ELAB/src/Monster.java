//elab-source:Monster.java
public class Monster implements Comparable{
    private String name;
    private int hitPoint;

    public Monster(String name, int hitPoint) {
        this.name = name;
        this.hitPoint = hitPoint;
    }

    public String toString() {
        return name + ":" + hitPoint;
    }

    @Override
    public int compareTo(Object o) {
        if (this.hitPoint > ((Monster) o).hitPoint) return -1;
        else if (this.hitPoint < ((Monster) o).hitPoint) return 1;
        else return 0;
    }
}
