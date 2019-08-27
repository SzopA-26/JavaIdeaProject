package sample;

public class GameController {
    private Monster m1, m2;
    private int turn; // -1 , 1
    private int round;


    public GameController(Monster m1, Monster m2){
        this.m1 = m1;
        this.m2 = m2;
        this.turn = -1;
        this.round = 0;

    }
    public void attackState(){
        if (getTurn() > 0) {
            m1.attack(m2);
        } else if (getTurn() < 0) {
            m2.attack(m1);
        }
    }
    public void healState(int heal){
        if (getTurn() > 0) {
            m1.heal(heal);
        } else if (getTurn() < 0) {
            m2.heal(heal);
        }
    }

    public boolean isWin(){
        if (m1.isAlive() && m2.isAlive()) {
            return false;
        } else {
            return true;
        }
    }
    public Monster getWinMonster(){
        if (m1.getHp() >= m2.getHp()){
            return m1;
        }
        return m2;
    }
    void changeTurn(){
        this.turn *= -1;
        System.out.println("change to " + turn);
        if (turn == 1) round++;
    }

    public int getTurn() {
        return turn;
    }

    public int getRound() {
        return round;
    }
}
