import java.util.ArrayList;
import java.util.Scanner;

public class Tree {
    private int numNode;
    private Tree parent = null;
    private ArrayList<Tree> child = new ArrayList<>();

    public Tree(int numNode) {
        this.numNode = numNode;
    }

    public void addChild(Tree tree) {
        child.add(tree);
    }

    public void printPre() {
        System.out.print(numNode+" ");
        for (Tree c : child) {
            c.printPre();
        }
    }

    public void printPost() {
        for (Tree c : child) {
            c.printPost();
        }
        System.out.print(numNode+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> save = new ArrayList<>();
        ArrayList<Tree> node = new ArrayList<>();
        int n = sc.nextInt();
        int root = sc.nextInt();
        node.add(new Tree(root));
        save.add(root);
        for (int i=0;i<n;i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            if (!save.contains(p)) {
                node.add(new Tree(p));
                save.add(p);
            }
            if (!save.contains(c)) {
                node.add(new Tree(c));
                save.add(c);
            }
            node.get(save.indexOf(p)).addChild(node.get(save.indexOf(c)));
        }
        node.get(0).printPre();
        System.out.println();
        node.get(0).printPost();

    }
}
