package MniTwitter;

//elab-source: MniTwitter.User.java
import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<User> follower = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public void follow(User user) {
        user.getFollower().add(this);
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<User> getFollower() {
        return follower;
    }
}
