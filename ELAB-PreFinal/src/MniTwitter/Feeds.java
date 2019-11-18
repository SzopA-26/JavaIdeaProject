package MniTwitter;

//elab-source: MniTwitter.Feeds.java
import java.util.ArrayList;

public class Feeds {
    private ArrayList<String> feed = new ArrayList<>();
    private ArrayList<String> owner = new ArrayList<>();

    public void post(String name, String content) {
        feed.add(content);
        owner.add(name);
    }

    public ArrayList<String> getFeed() {
        return feed;
    }

    public ArrayList<String> getOwner() {
        return owner;
    }
}
