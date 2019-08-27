package sample;
import java.util.Scanner ;
public class Monster {
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int maxHp;
    private boolean heal = false;
    private String imgPath;

    public Monster(String name, int hp, int atk, int def, String imgPath) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.maxHp = hp;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
    public int getMaxHp() {return maxHp;}

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public boolean getHeal() {
        return heal;
    }

    public String getImgPath() {
        return imgPath;
    }

    public boolean isDead() {
        if(hp <= 0){
            return true;
        }
        return false;
    }




    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void attack(Monster m2) {
        if (atk > m2.def) {
            m2.hp -= atk - m2.def;
            if (m2.hp < 0) {
                m2.hp = 0;
            }
        }
    }

    public void heal(int hp) {
        heal = true;
        this.hp += hp;
        if (this.hp > maxHp) {
            this.hp = maxHp;
        }
    }

    public void recovery() {
        heal = false;
    }

    public String toString() {
        return name + " atk : " + atk + " def : " + def + " hp : " + hp + "/" + maxHp;
    }
}