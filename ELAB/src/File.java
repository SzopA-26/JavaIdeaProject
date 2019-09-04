//elab-source:File.java

public class File {
    private String name;
    private String children;

    public File(String name) {
        this.name = name;
        this.children = "";
    }

    public String getName() {
        return name;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

}
