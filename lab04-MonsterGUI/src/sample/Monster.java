package sample;

public class Monster {
    private String name;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;
    private boolean alive = true;
    private boolean canAtk = true;
    private String imgPath;

    public Monster(String name, int hp, int atk, int def, String imgPath) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        if (hp == 0) alive = false;
        this.atk = atk;
        this.def = def;
        this.imgPath = imgPath;
    }

    public void heal(int hp) {
        if (this.hp + hp >= maxHp)
            this.hp = maxHp;
        else
            this.hp += hp;
        canAtk = false;

    }

    public void setCanAtk() {
        canAtk = true;
    }

    public void attack(Monster other) {
        if (getAtk() > other.getDef()) {
            if (other.getHp() - getAtk() <= 0) {
                other.setHp(0);
                other.setAlive();
            }
            else other.setHp(other.getHp() - (atk - other.getDef()));
        }
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

    public boolean isAlive() {
        return alive;
    }

    public boolean getCanAtk() {
        return canAtk;
    }

    public String getImgPath() { return imgPath; }

    public void setImgPath(String imgPath) { this.imgPath = imgPath; }

    public void setHp(int hp) { this.hp = hp; }

    public void setAlive() {this.alive = false; }

    public String info() {
        return "Monster " + name + " atk: " + atk + " def: " + def + " hp: " + hp + "/" + maxHp;
    }
}