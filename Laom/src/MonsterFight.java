import java.sql.SQLOutput;
import java.util.Scanner;

public class MonsterFight {
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int maxHp;
    private boolean heal = false;

    public MonsterFight(String name, int hp, int atk, int def) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.maxHp = hp;
    }

    public String getName() {
        return name;
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

    public boolean getHeal() {
        return heal;
    }

    public void attack(MonsterFight m2) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("!!!!   Monster Fight  !!!!");
        System.out.println("Please input monster1 name hp atk def :");
        String name = sc.next();
        int hp = sc.nextInt();
        int atk = sc.nextInt();
        int def = sc.nextInt();
        MonsterFight m1 = new MonsterFight(name, hp, atk, def);
        System.out.println("Please input monster2 name hp atk def : ");
        name = sc.next();
        hp = sc.nextInt();
        atk = sc.nextInt();
        def = sc.nextInt();
        MonsterFight m2 = new MonsterFight(name, hp, atk, def);

        for (int i = 1; ; i++) {
            System.out.println("\nRound : " + i);
            if (m1.getHp() > 0) {
                System.out.println(">>> Monster 1 turn <<<");
                if (m1.getHeal() == false) {
                    System.out.println("Please enter skill A=attack H=heal");
                    String ac = sc.next();
                    if (ac.equals("a") || ac.equals("A")) {
                        m1.attack(m2);
                    } else if (ac.equals("h") || ac.equals("H")) {
                        System.out.println("Please enter recovery hp :");
                        hp = sc.nextInt();
                        m1.heal(hp);
                    }
                    System.out.println("Monster " + m1.toString());
                    System.out.println("Monster " + m2.toString());
                } else {
                    System.out.println("Monster 1 Can't use skill");
                    m1.recovery();
                }
                if (m2.getHp() > 0) {
                    System.out.println(">>> Monster 2 turn <<<");
                    if (m2.getHeal() == false) {
                        System.out.println("Please enter skill A=attack H=heal");
                        String ac = sc.next();
                        if (ac.equals("a") || ac.equals("A")) {
                            m2.attack(m1);
                        } else if (ac.equals("h") || ac.equals("H")) {
                            System.out.println("Please enter recovery hp :");
                            hp = sc.nextInt();
                            m2.heal(hp);
                        }
                        System.out.println("Monster " + m1.toString());
                        System.out.println("Monster " + m2.toString());
                    } else {
                        System.out.println("Monster 2 Can't use skill");
                        m2.recovery();
                    }

                }
            }
            if (m1.getHp() <= 0 || m2.getHp() <= 0) {
                System.out.println("\nThe Winner Is ..........");
                if (m1.getHp() > 0) {
                    System.out.println("Monster " + m1.toString());
                } else if (m2.getHp() > 0) {
                    System.out.println("Monster " + m2.toString());
                }
                break;


            }

        }

    }
}
