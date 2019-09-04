import java.util.*;

public class DentalClinic {
    private String name;
    private int time;

    public DentalClinic(String name, int time) {
        this.name = name.substring(1);
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nq = sc.nextInt();
        int sumTime = 0;
        Queue<DentalClinic> que = new LinkedList<>();
        for (int i=0;i<nq;i++) {
            String cus = sc.next();
            int cusTime = Integer.parseInt(sc.next().substring(5));
            que.add(new DentalClinic(cus,cusTime));
            sumTime += cusTime;
        }

        int nDq = sc.nextInt();
        List<String> cusDq = new LinkedList<>();
        for (int i=0; i<nDq; i++) {
            cusDq.add(sc.next().substring(1));
        }

        int timeQ = sc.nextInt();
        for (int i=0; !que.isEmpty() && i<sumTime; ){
            if (cusDq.contains(que.peek().getName()))
                que.poll();
            else if (i<=timeQ)
                i += que.poll().getTime();
            else
                System.out.println(que.poll().getName());
        }
    }
}
