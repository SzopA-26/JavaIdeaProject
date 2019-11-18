public class Weapon {
    private int damage;
    private int durability;

    public Weapon(int damage, int durability) {
        this.damage = damage;
        this.durability = durability;
    }

    public int getDamage() {
        return damage;
    }

    public void use() {
        if (--durability < 0) durability = 0;
    }
}
