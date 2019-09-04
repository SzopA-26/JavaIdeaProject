//elab-source:SquareObstacle.java

public class SquareObstacle extends Obstacle {
    public String image() {
        String s = "";
        for (int i=0;i<super.getLength();i++) {
            s += super.image();
            if (i<super.getLength()-1)
                s += "\n";
        } return s;
    }
}
