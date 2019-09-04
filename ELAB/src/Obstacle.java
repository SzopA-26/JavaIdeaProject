//elab-source:Obstacle.java

public class Obstacle {
    private int length;
    private char image;

    public Obstacle() {
        this.length = 0;
        this.image = '*';
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String image() {
        String s = "";
        for(int i=0;i<length;i++)
            s += image;
        return s;
    }

    public int getLength() {
        return length;
    }

    protected void setImage(char image) {
        this.image = image;
    }
}
