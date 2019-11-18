import java.util.*;

public class TreasureInTheMaze2 {
    private ArrayList<Character> treasure = new ArrayList<>();
    private ArrayList<ArrayList<Character>> map;
    private int height;
    private int weight;
    private int stepTarget;
    private char treasureTarget;
    private int timeCount; // LOL~ (><) HAHAHA

    public TreasureInTheMaze2(ArrayList<ArrayList<Character>> map) {
        treasure.add('^'); treasure.add('+'); treasure.add('*'); treasure.add('$');
        this.height = map.size();
        this.weight = map.get(0).size();
        this.map = map;
        this.stepTarget = 0;
        this.treasureTarget = '.';
        timeCount = 0;
    }

    public void findTheUltimateTreasure(int row, int column, int currentStep, ArrayList<String> pass) {
        timeCount++;
        ArrayList<String> passPos = (ArrayList<String>) pass.clone();
//        System.out.println(row + " " + column + " " + map.get(row).get(column));
//        System.out.println("CURRENT STEP " + currentStep);
        passPos.add(row + "-" + column);
//        System.out.println(passPos.toString());
        currentStep++; if (timeCount < 100000000) {
        if (canGo(row-1,column) && !passPos.contains((row-1)+"-"+column)) {
            checkTreasure(map.get(row-1).get(column),currentStep);
            if (map.get(row-1).get(column) != '#' && !treasure.contains(map.get(row-1).get(column))) {
                findTheUltimateTreasure(row-1,column,currentStep,passPos);
//                System.out.println("BACK TO " + row + " " + column);
            }
        } if (canGo(row,column+1) && !passPos.contains(row+"-"+(column+1))) {
            checkTreasure(map.get(row).get(column+1),currentStep);
            if (map.get(row).get(column+1) != '#' && !treasure.contains(map.get(row).get(column+1))) {
                findTheUltimateTreasure(row,column+1,currentStep,passPos);
//                System.out.println("BACK TO " + row + " " + column);
            }
        } if (canGo(row+1,column) && !passPos.contains((row+1)+"-"+column)) {
            checkTreasure(map.get(row+1).get(column),currentStep);
            if (map.get(row+1).get(column) != '#' && !treasure.contains(map.get(row+1).get(column))) {
                findTheUltimateTreasure(row+1,column,currentStep,passPos);
//                System.out.println("BACK TO " + row + " " + column);
            }
        } if (canGo(row,column-1) && !passPos.contains(row+"-"+(column-1))) {
            checkTreasure(map.get(row).get(column-1),currentStep);
            if (map.get(row).get(column-1) != '#' && !treasure.contains(map.get(row).get(column-1))) {
                findTheUltimateTreasure(row,column-1,currentStep,passPos);
//                System.out.println("BACK TO " + row + " " + column);
            }
        }
    }}

    public boolean canGo(int r, int c) {
        return (r>=0 && c>=0 && r<height && c<weight);
    }

    public void checkTreasure(char t,int s){
        if (treasure.contains(t)) {
//            System.out.println("FOUNDDDDDDDDD " + s + " " + t);
            if (treasure.indexOf(t) > treasure.indexOf(treasureTarget)) {
                treasureTarget = t;
                stepTarget = s;
//                System.out.println("SAVE");
            } else if (treasure.indexOf(t) == treasure.indexOf(treasureTarget) && stepTarget > s) {
                stepTarget = s;
//                System.out.println("SAVE");
            }
        }
    }

    public int getStepTarget() {
        return stepTarget;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(); int column = sc.nextInt();
        int startR = 0; int startC = 0;
        ArrayList<ArrayList<Character>> map = new ArrayList<>();
        for (int i=0;i<row;i++) {
            char[] col = sc.next().toCharArray();
            ArrayList<Character> node = new ArrayList<>();
            for (char c: col) {
                node.add(c);
                if (c == 's') {
                    startR = i;
                    startC = node.indexOf(c);
                }
            }
            map.add(node);
        }

        TreasureInTheMaze2 maze = new TreasureInTheMaze2(map);
        maze.findTheUltimateTreasure(startR,startC,0,new ArrayList<>());


        if (maze.getStepTarget() == 0)
            System.out.println("not found treasure");
        else System.out.println(maze.getStepTarget());
    }
}
