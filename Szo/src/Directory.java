import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Directory {
    private String name;
    private Directory parent = null;
    private ArrayList<Directory> child = new ArrayList<>();
    private String path;

    public Directory(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void addChild(Directory directory) {
        child.add(directory);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> save = new ArrayList<>();
        ArrayList<Directory> directories = new ArrayList<>();
        int n = sc.nextInt();
        String root = sc.next();
        save.add(root);
        directories.add(new Directory(root,root));
        for (int i=0;i<n;i++) {
            String parent = sc.next();
            String child = sc.next();
            if (!save.contains(child)) {
                save.add(child);
                directories.add(new Directory(child,directories.get(save.indexOf(parent)).getPath()+"/"+child));
            }
        } String tar = sc.next();
        System.out.println(directories.get(save.indexOf(tar)).getPath());


    }
}
