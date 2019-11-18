package MniTwitter;

//elab-source: MniTwitter.Permission.java
public interface Permission {
    boolean hasPermission(User user, User otherUser);
}
