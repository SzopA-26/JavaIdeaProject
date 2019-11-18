package MniTwitter;

//elab-source: MniTwitter.Follower.java
public class Follower implements Permission {
    @Override
    public boolean hasPermission(User user, User otherUser) {
        if (user == otherUser) return true;
        return otherUser.getFollower().contains(user);
    }
}
