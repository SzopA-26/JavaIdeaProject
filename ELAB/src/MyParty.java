import java.util.ArrayList;
import java.util.Collections;

public class MyParty implements MonsterParty {
    @Override
    public ArrayList<Monster> createMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Thief Bug", 500));
        monsters.add(new Monster("Ant Egg", 5000));
        monsters.add(new Monster("Poring", 10));
        monsters.add(new Monster("Rare Mandragora", 38));
        return monsters;
    }

    public static void main(String[] args) {
        MonsterParty party = new MyParty();
        ArrayList<Monster> monsters = party.createMonsters();
        System.out.println(monsters);
        Collections.sort(monsters);
        System.out.println(monsters);
    }
}
