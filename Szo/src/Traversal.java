import java.util.ArrayList;
import java.util.Scanner;

public class Traversal {
    private int key;
    private Traversal left;
    private Traversal right;

    public Traversal(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    public void setLeft(Traversal left) {
        this.left = left;
    }

    public void setRight(Traversal right) {
        this.right = right;
    }

    public void printPreOrder(Traversal node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printInOrder(Traversal node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    public void printPostOrder(Traversal node) {
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key + " ");
    }

    public static void main(String[] args) {
        ArrayList<Traversal> tree = new ArrayList<>();
        ArrayList<Integer> map = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        Traversal root = new Traversal(r);
        tree.add(root);
        map.add(r);
        for (int i=0;i<n;i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            char d = sc.next().charAt(0);
            tree.add(new Traversal(c));
            map.add(c);
            if (d == 'L') {
                tree.get(map.indexOf(p)).setLeft(tree.get(map.indexOf(c)));
            } else if ( d == 'R') {
                tree.get(map.indexOf(p)).setRight(tree.get(map.indexOf(c)));
            }
        }

        if (tree.size() != 0) {
            root.printPreOrder(root);
            System.out.println();
            root.printInOrder(root);
            System.out.println();
            root.printPostOrder(root);
        }
    }
}
