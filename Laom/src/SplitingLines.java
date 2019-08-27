import java.util.Arrays;
        import java.util.Comparator;
        import java.util.Scanner;

public class SplitingLines {
    private String name;
    private double height;

    public SplitingLines(String name, double height) {
        this.name=name;
        this.height=height;
    }
    public String getName(){
        return name;
    }
    public double getHeight(){
        return height;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SplitingLines[] stu = new SplitingLines[n];
        for(int i = 0;i < n;i++){
            String name = sc.next();
            int height = sc.nextInt();
            stu[i] = new SplitingLines(name, height);
        }

        Arrays.sort(stu, new Comparator<SplitingLines>() {
            @Override
            public int compare(SplitingLines o1, SplitingLines o2) {
                double diff = o1.getHeight()- o2.getHeight();
                return diff > 0? 1 : diff == 0? 0 : -1;
            }
        });

        int cut = sc.nextInt();
        double row = Math.ceil((double)n/cut);

        System.out.println((int)row);

        for(int i = 0;i<n;i+=cut){
            System.out.println(stu[i].getName());
        }

    }



}
