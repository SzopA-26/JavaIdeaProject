public class Monster {
    private String name;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;
    private boolean alive = true;
    private boolean heal = true;

    public Monster(String name, int hp, int atk, int def) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        if (hp == 0) alive = false;
        this.atk = atk;
        this.def = def;
    }

    public void heal(int hp) {
        if (this.hp + hp >= maxHp)
            this.hp = maxHp;
        else
            this.hp += hp;
        heal = false;

    }

    public void recover() {
        heal = true;
    }

    public void defend(Monster other) {
        if (other.atk > def)
            if ((hp+def)-other.atk <= 0) {
                hp = 0;
                alive = false;
            }
            else
                hp -= other.atk-def;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public boolean getAlive() {
        return alive;
    }

    public boolean getHeal() {
        return heal;
    }

    public String info() {
        return "Monster " + name + " atk: " + atk + " def: " + def + " hp: " + hp + "/" + maxHp;
    }
}