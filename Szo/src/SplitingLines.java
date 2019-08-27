import java.util.Arrays;
import java.util.Scanner;

public class SplitingLines {
    private String name;
    private int height;
    private boolean assign = false;

    public SplitingLines(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void setAssign() {
        assign = true;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public boolean getAssign() {
        return assign;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] hStu = new int[n];
        SplitingLines[] stu = new SplitingLines[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            hStu[i] = height;
            stu[i] = new SplitingLines(name, height);
        }
        int nr = sc.nextInt();
        Arrays.sort(hStu);
        int nPerRow = n / nr;
        if (n % nr != 0) nPerRow++;
        System.out.println(nPerRow);
        for (int i = 0, r = 0; i < nPerRow; i++, r += nr) {
            for (int j = 0; j < n; j++) {
                if (hStu[r] == stu[j].getHeight() && !stu[j].getAssign()) {
                    System.out.println(stu[j].getName());
                    stu[j].setAssign();
                    break;
                }
            }
        }


    }
}
