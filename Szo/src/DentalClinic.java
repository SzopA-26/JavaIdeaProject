import java.util.*;

public class DentalClinic {
    private String name;
    private int time;

    public DentalClinic(String name, String time) {
        StringBuilder strN = new StringBuilder();
        for (int i=0; i<name.length() ;i++)
            if (name.charAt(i)!='+')
                strN.append(name.charAt(i));
        String strT[] = time.split("time=");
        this.name = strN.toString();
        this.time = Integer.parseInt(strT[1]);
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
            String cusTime = sc.next();
            DentalClinic customer = new DentalClinic(cus,cusTime);
            que.add(customer);
            sumTime += customer.getTime();
        }

        int nDq = sc.nextInt();
        List<String> cusDq = new LinkedList<>();
        for (int i=0; i<nDq; i++) {
            String[] dQ = sc.next().split("-");
            cusDq.add(dQ[1]);
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
