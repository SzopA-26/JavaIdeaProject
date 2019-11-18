import java.util.ArrayList;
import java.util.Scanner;

public class Leaf {
    private char key;
    private Leaf left;
    private Leaf right;

    public Leaf(char key) {
        this.key = key;
        left = right = null;
    }

    public void setLeft(Leaf left) {
        this.left = left;
    }

    public void setRight(Leaf right) {
        this.right = right;
    }

    public int getCountLeaf(Leaf node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        else return getCountLeaf(node.left) + getCountLeaf(node.right);
    }

    public static void main(String[] args) {
        ArrayList<Leaf> tree = new ArrayList<>();
        ArrayList<Character> map = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        char r = sc.next().charAt(0);
        int n = sc.nextInt();
        Leaf root = new Leaf(r);
        tree.add(root);
        map.add(r);
        for (int i=0;i<n;i++) {
            char p = sc.next().charAt(0);
            char c = sc.next().charAt(0);
            char d = sc.next().charAt(0);
            map.add(c);
            tree.add(new Leaf(c));
            if (d == 'L') {
                tree.get(map.indexOf(p)).setLeft(tree.get(map.indexOf(c)));
            } else if ( d == 'R') {
                tree.get(map.indexOf(p)).setRight(tree.get(map.indexOf(c)));
            }
        }

        System.out.println( root.getCountLeaf(root.left) + " "  + root.getCountLeaf(root.right));
    }
}
