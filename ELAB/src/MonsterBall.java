//elab-source:MonsterBall.java
//elab-mainclass:MonsterBall

public class MonsterBall {
    private String type;
    private double price;
    private double sell;
    private double value;

    public MonsterBall(String type, double price, double sell, double value) {
        this.type = type;
        this.price = price;
        this.sell = sell;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getSell() {
        return sell;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MonsterBall{type='" + getType() + "', price=" + getPrice() + ", sellFor=" + getSell() + ", ballValue=" + getValue()+"}";
    }

    public static void main(String[] args) {
        MonsterBall[] ball = new MonsterBall[4];
        ball[0] = new MonsterBall("Poke Ball",200,100,1);
        ball[1] = new MonsterBall("Great Ball",600,300,1.5);
        ball[2] = new MonsterBall("Ultra Ball",1200,600,2);
        ball[3] = new MonsterBall("Drive Ball",1000,500,3.5);
        for (MonsterBall b : ball) {
            System.out.println(b.toString());
        }
    }
}
