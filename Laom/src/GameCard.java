import java.util.Scanner;
import java.util.Stack;

public class GameCard {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Stack[] card = new Stack[n];
        for(int i = 0;i < n;i++){
            card[i] = new Stack<String>();
            for(int j=0;j < m;j++) {
                String c = sc.next();
                if(c.equals("+")){
                    int last = (int)card[i].pop();
                    int plus = last+(int)card[i].peek();
                    card[i].push(last);
                    card[i].push(plus);
                }
                else if(c.equals("D")){
                    int multi = (int)card[i].peek()*2;
                    card[i].push(multi);
                }
                else if(c.equals("C")){
                    card[i].pop();
                }
                else{
                    card[i].push(Integer.valueOf(c));
                }
            }
        }
        for(int i = 0;i < n;i++){
            int out = 0;
            for(;!card[i].isEmpty();){
                out+=(int)card[i].pop();
            }
            System.out.print(out+" ");
        }
    }
}
