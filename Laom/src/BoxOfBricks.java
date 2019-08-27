import java.util.Scanner;

public class BoxOfBricks {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bricks[] = new int[n];
        int sumHeight = 0;
        for(int i = 0;i < n;i++){
            bricks[i]=sc.nextInt();
            sumHeight+=bricks[i];
        }
        int out = 0;
        for(int i = 0;i < n;i++){
            if(bricks[i]>sumHeight/n){
                out+=bricks[i]-sumHeight/n;
            }
        }
        System.out.println(out);
    }
}
