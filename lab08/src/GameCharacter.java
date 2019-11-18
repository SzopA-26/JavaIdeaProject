class GameCharacter {
    private int hp;
    private String name;
    private int damage;
    private Weapon weapon;

    public GameCharacter(String name, int hp, int damage, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.weapon = weapon;
    }

    public int getDamage() {
        return damage + weapon.getDamage();
    }

    public void isAttackedWith(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void attack(GameCharacter enemy) {
        weapon.use();
        enemy.isAttackedWith(getDamage());
    }

}
