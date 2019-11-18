package MniTwitter;

//elab-source: MniTwitter.MiniTwitter.java
import java.util.ArrayList;

public class MiniTwitter {
    private ArrayList<User> userList = new ArrayList<>();
    private Feeds feeds = new Feeds();
    private Permission permission;

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    private User findUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username))
                return user;
        } return null;
    }

    public void post(String username, String content) {
        feeds.post(username, content);
    }

    public ArrayList<String> getNewFeeds(String username) {
        User user = findUser(username);
        ArrayList<String> newFeeds = new ArrayList<>();
        for (int i=0; i<feeds.getFeed().size(); i++) {
            if (permission.hasPermission(user, findUser(feeds.getOwner().get(i))))
                newFeeds.add("(" + feeds.getOwner().get(i) + ") " + feeds.getFeed().get(i));
        }
        return newFeeds;
    }

    public void follow(String username, String otherUsername) {
        if (findUser(username) == null || findUser(otherUsername) == null) return;
        findUser(username).follow(findUser(otherUsername));
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
