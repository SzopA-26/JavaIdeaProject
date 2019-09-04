//elab-source:MiniFileSystem.java
//elab-mainclass:MiniFileSystem

import java.util.ArrayList;
import java.util.Scanner;

public class MiniFileSystem {
    private ArrayList<File> listFile;

    public MiniFileSystem() {
        this.listFile = new ArrayList<>();
    }

    public int searchFile(String name) {
        for (int i=0;i<listFile.size();i++) {
            if (listFile.get(i).getName().equals(name))
                return i;
        } return -1;
    }

    public File getFile(String name) {
        return listFile.get(searchFile(name));
    }

    public void setChildren(String name, String children) {
        listFile.get(searchFile(name)).setChildren(children);
    }

    public void addFile(File file) {
        listFile.add(file);
    }

    public String toString() {
        String s = "";
        for (File i : listFile)
            s += i.getName() + " - " + i.getChildren() + "\n";
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MiniFileSystem file = new MiniFileSystem();
        while (true) {
            String command = sc.next();
            if (command.equals("touch")) {
                String newFile = sc.next();
                if (file.searchFile(newFile) < 0)
                    file.addFile(new File(newFile));
                else
                    System.out.println("File " + newFile + " Already Exist");
            } else if (command.equals("echo")) {
                String line = sc.nextLine();
                String children;
                String arrow;
                String fileName;
                if (line.contains("\"")) {
                    String[] com = line.split("\"");
                    children = com[1];
                    arrow =  com[2].split(" ")[1];
                    fileName = com[2].split(" ")[2];
                } else {
                    children = line.split(" ")[1];
                    arrow = line.split(" ")[2];
                    fileName = line.split(" ")[3];
                }
                if (file.searchFile(fileName) >= 0) {
                    if (arrow.equals(">>"))
                        file.setChildren(fileName,file.getFile(fileName).getChildren() + children);
                    else if (arrow.equals(">"))
                        file.setChildren(fileName,children);
                } else
                    System.out.println("File " + fileName + " Not Found");
            } else if (command.equals("cat")) {
                String fileName = sc.next();
                if (file.searchFile(fileName) >= 0)
                    System.out.println(file.getFile(fileName).getChildren());
                else
                    System.out.println("File " + fileName + " Not Found");
            } else if (command.equals("exit"))
                break;
            else if (command.equals("ls")) {
                System.out.print(file.toString());
            }
        }
    }
}
