package MniTwitter;

//elab-source: MniTwitter.CreativeNote.Property.Exception.MovieComparator.Dictionary.MainProgram.java
//elab-mainclass: MniTwitter.CreativeNote.Property.Exception.MovieComparator.Dictionary.MainProgram

import java.util.Scanner;

public class MainProgram {
    public static void main(String args[]) {
        MiniTwitter twitter = new MiniTwitter();
        twitter.setPermission(new Follower());

        Scanner sc = new Scanner(System.in);
        int nUser = sc.nextInt();
        for (int i = 0; i < nUser; i++)
            twitter.addUser(new User(sc.next()));

        int nFollow = sc.nextInt();
        for (int i = 0; i < nFollow; i++)
            twitter.follow(sc.next(), sc.next());

        int nPost = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nPost; i++) {
            String line = sc.nextLine();
            String username = line.split("/")[0];
            String content = line.split("/")[1];
            twitter.post(username, content);
        }

        for (User user : twitter.getUserList()) {
            System.out.println(user.getUsername() + ":");
            for (String feed : twitter.getNewFeeds(user.getUsername())) {
                System.out.println(feed);
            }
        }
    }
}
