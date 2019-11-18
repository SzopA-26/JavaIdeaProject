import java.util.ArrayList;
import java.util.Scanner;

public class Node {
    private ArrayList<Node> ch = new ArrayList<>();

    public void addNode(Node node) {
        ch.add(node);
    }

    public int countChildNodes() {
        int count = ch.size();
        for (Node n : ch)
            count += n.countChildNodes();
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        int r = sc.nextInt();
        for (int i=0;i<n;i++)
            nodes[i] = new Node();
        for (int i=0;i<r;i++) {
            int m = sc.nextInt(); int c = sc.nextInt();
            nodes[m-1].addNode(nodes[c-1]);
        } int tNode = sc.nextInt();
        System.out.println(nodes[tNode-1].countChildNodes());

    }
}
