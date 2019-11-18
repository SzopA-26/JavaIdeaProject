import java.util.ArrayList;
import java.util.Scanner;

public class NodesEveryWhere {
    private ArrayList<NodesEveryWhere> child;

    public NodesEveryWhere() {
        this.child = new ArrayList<>();
    }

    public void addChild(NodesEveryWhere node) {
        child.add(node);
    }

    public int countChild() {
        int count = 0;
        for (NodesEveryWhere n : child) {
            count += n.countChild() + 1;
        } return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nNodes = sc.nextInt();
        NodesEveryWhere[] nodes = new NodesEveryWhere[nNodes];
        for (int i=0;i<nNodes;i++)
            nodes[i] = new NodesEveryWhere();
        int nRela = sc.nextInt();
        for (int i=0;i<nRela;i++) {
            int mom = sc.nextInt();
            int child = sc.nextInt();
            nodes[mom-1].addChild(nodes[child-1]);
        }
        int node = sc.nextInt();
        System.out.println(nodes[node-1].countChild());
    }
}
