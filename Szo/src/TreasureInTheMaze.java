import java.util.ArrayList;
import java.util.Scanner;

public class TreasureInTheMaze {
    private ArrayList<Character> treasure = new ArrayList<>();
    private ArrayList<ArrayList<Character>> map;
    private int height;
    private int weight;
    private int stepTarget;
    private char treasureTarget;
    private ArrayList<String> passPos = new ArrayList<>();

    public TreasureInTheMaze(ArrayList<ArrayList<Character>> map, int sR, int sC) {
        treasure.add('^'); treasure.add('+'); treasure.add('*'); treasure.add('$');
        this.height = map.size() - 1;
        this.weight = map.get(0).size() - 1;
        this.map = map;
        this.stepTarget = 0;
        this.treasureTarget = '.';
        String pos = sR + "-" + sC;
        this.passPos.add(pos);
    }

    public void findTheUltimateTreasure(int row, int column, int currentStep) {
        System.out.println(row + " " + column + " " + map.get(row).get(column));
        System.out.println("CURRENT STEP " + currentStep);
        System.out.println(passPos);
        if (treasure.contains(map.get(row).get(column))) {
            if (treasure.indexOf(map.get(row).get(column)) > treasure.indexOf(treasureTarget)) {
                stepTarget = currentStep;
                treasureTarget = map.get(row).get(column);
            } else if ((map.get(row).get(column) == treasureTarget) && (stepTarget > currentStep)) {
                stepTarget = currentStep;
                treasureTarget = map.get(row).get(column);
            }
            System.out.println("SAVE STEP >>>>>>>>> " + stepTarget);
        } else {
            currentStep++;
            if ((row - 1 >= 0) && (map.get(row-1).get(column) != '#') && (map.get(row-1).get(column) != 's')) {
                if (!passPos.contains((row-1) + "-" + column)) {
                    updateArray(currentStep, (row-1) + "-" + column);
                    findTheUltimateTreasure(row-1, column, currentStep);
                    System.out.println("BACK TO " + row + " " +column);
                }
            } if ((column + 1 <= weight) && (map.get(row).get(column+1) != '#') && (map.get(row).get(column+1) != 's')) {
                if (!passPos.contains(row + "-" + (column+1))) {
                    updateArray(currentStep, row + "-" + (column+1));
                    findTheUltimateTreasure(row, column+1, currentStep);
                    System.out.println("BACK TO " + row + " " +column);
                }
            } if ((row + 1 <= height) && (map.get(row+1).get(column) != '#') && (map.get(row+1).get(column) != 's')) {
                if (!passPos.contains((row+1) + "-" + (column))) {
                    updateArray(currentStep, (row+1) + "-" + column);
                    findTheUltimateTreasure(row+1, column, currentStep);
                    System.out.println("BACK TO " + row + " " +column);
                }
            } if ((column - 1 >= 0) && (map.get(row).get(column-1) != '#') && (map.get(row).get(column-1) != 's')) {
                if (!passPos.contains(row + "-" + (column-1))) {
                    updateArray(currentStep, row + "-" + (column-1));
                    findTheUltimateTreasure(row, column-1, currentStep);
                    System.out.println("BACK TO " + row + " " +column);
                }
            }
        }
    }

    public void updateArray(int index, String pos) {
//        passPos.add(index,pos);
//        for (int i=index+1;i<passPos.size();) {
//            passPos.remove(i);
//        }

        passPos.add(index,pos);
        while (index >= passPos.size()-1) {
            passPos.remove(passPos.size()-1);
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

        TreasureInTheMaze maze = new TreasureInTheMaze(map,startR,startC);
        maze.findTheUltimateTreasure(startR,startC,0);

        System.out.println(maze.getStepTarget());
    }
}
