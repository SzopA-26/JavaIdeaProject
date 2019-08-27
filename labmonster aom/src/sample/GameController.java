package sample;

public class GameController {
    private Monster m1, m2;
    private int turn; // -1 , 1
    private int round;


    public GameController(Monster m1, Monster m2){
        this.m1 = m1;
        this.m2 = m2;
        this.turn = 1;
        this.round = 1;

    }
    public void attackState(){
        if(turn == 1){
            m1.attack(m2);
        }
        else{
            m2.attack(m1);
        }
        changeTurn();
    }
    public void healState(int heal){
        if(turn == 1){
            m1.heal(heal);
        }
        else{
            m2.heal(heal);
        }
        changeTurn();
    }

    public boolean isWin(){
        if (m1.isDead() || m2.isDead()){
            return true;
        }
        return false;
    }
    public Monster getWinMonster(){
        if (m1.getHp() > m2.getHp()){
            return m1;
        }
        return m2;
    }
    private void changeTurn(){
        this.turn *= -1;
        if (turn==1){
            round++;
        }
    }

    public int getTurn() {
        return turn;
    }

    public int getRound() {
        return round;
    }
}
