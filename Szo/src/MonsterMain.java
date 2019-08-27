import java.util.Scanner;

public class MonsterMain {

    public static Monster createMonster() {
        System.out.println("Please Enter Monster name: ");
        Scanner scName = new Scanner(System.in);
        String name = scName.next();
        int hp,atk,def;
        while (true) {
            System.out.println("Please Enter " +name+ " hp atk def:");
            Scanner sc = new Scanner(System.in);
            hp = sc.nextInt();
            atk = sc.nextInt();
            def = sc.nextInt();
            if (hp < 0 || atk < 0 || def < 0)
                System.out.println("!!! Input Error please try again.");
            else
                break;
        }
        return new Monster(name, hp, atk, def);
    }

    public static void fight(Monster m1, Monster m2) {
        System.out.println("Please enter skill A=attack H=heal");
        Scanner scSkill = new Scanner(System.in);
        String skill = scSkill.nextLine();
        if (skill.equals("A") || skill.equals("a")) {
            m2.defend(m1);
        } else if (skill.equals("H") || skill.equals("h")) {
            System.out.println("Please enter recovery hp:");
            Scanner scHeal = new Scanner(System.in);
            int heal = scHeal.nextInt();
            m1.heal(heal);
        }
    }

    public static void main(String[] args) {
        System.out.println("!!!!   Monster Fight  !!!!");
        System.out.println("Monster-1 :");
        Monster m1 = createMonster();
        System.out.println("Monster-2 :");
        Monster m2 = createMonster();

        for (int i=1;;i++) {
            if (m1.getAlive() && m2.getAlive()){
                System.out.println("\nRound : " + i);
                System.out.println(">>> Monster " + m1.getName() + " turn <<<");
                if (m1.getHeal()) {
                    fight(m1, m2);
                    System.out.println(m1.info());
                    System.out.println(m2.info());
                } else if (!m1.getHeal()){
                    m1.recover();
                    System.out.println(m1.getName() + " Can't use skill");
                }
                if (m2.getAlive()) {
                    System.out.println(">>> Monster " + m2.getName() + " turn <<<");
                    if (m2.getHeal() && m2.getAlive()) {
                        fight(m2, m1);
                        System.out.println(m1.info());
                        System.out.println(m2.info());
                    } else if (!m2.getHeal()) {
                        m2.recover();
                        System.out.println(m2.getName() + " Can't use skill");
                    }
                }
            } else {
                System.out.println("\nThe Winner Is ..........");
                if (m1.getAlive()) {
                    System.out.println(m1.info());
                } else if (m2.getAlive()) {
                    System.out.println(m2.info());
                } break;
            }
        }
    }
}