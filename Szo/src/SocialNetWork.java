import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SocialNetWork {
    private String name;
    private ArrayList<SocialNetWork> friends;

    public SocialNetWork(String name) {
        this.name = name;
        friends = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<SocialNetWork> getFriends() {
        return friends;
    }

    public void addFriend (SocialNetWork socialNetWork) {
        friends.add(socialNetWork);
        socialNetWork.getFriends().add(this);
    }

    public void unFriend (SocialNetWork socialNetWork) {
        friends.remove(socialNetWork);
        socialNetWork.getFriends().remove(this);
    }

    public ArrayList<SocialNetWork> getAllFriends() {
        ArrayList<SocialNetWork> friendAndMutual = new ArrayList<>();
        for (SocialNetWork s : friends) {
            friendAndMutual.add(s);
            friendAndMutual.addAll(s.getFriends());
            friendAndMutual.remove(this);
        }
        return friendAndMutual;
    }

    public static void main(String[] args) {
        ArrayList<SocialNetWork> socialNetWorks = new ArrayList<>();
        ArrayList<String> userName = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
            String f1 = sc.next();
            if (!userName.contains(f1)) {
                socialNetWorks.add(new SocialNetWork(f1));
                userName.add(f1);
            }
            String f2 = sc.next();
            if (!userName.contains(f2)) {
                socialNetWorks.add(new SocialNetWork(f2));
                userName.add(f2);
            }
            if (!f1.equals(f2))
                if (!socialNetWorks.get(userName.indexOf(f1)).getFriends().contains(socialNetWorks.get(userName.indexOf(f2))))
                    socialNetWorks.get(userName.indexOf(f1)).addFriend(socialNetWorks.get(userName.indexOf(f2)));
        }

        n = sc.nextInt();
        for (int i=0;i<n;i++) {
            String f1 = sc.next();
            String f2 = sc.next();
            socialNetWorks.get(userName.indexOf(f1)).unFriend(socialNetWorks.get(userName.indexOf(f2)));
        }
        String name = sc.next();
        ArrayList<SocialNetWork> s = socialNetWorks.get(userName.indexOf(name)).getAllFriends();
        s.sort(new Comparator<SocialNetWork>() {
            @Override
            public int compare(SocialNetWork o1, SocialNetWork o2) {
                if ((int)o1.getName().toLowerCase().charAt(0) < (int)o2.getName().toLowerCase().charAt(0))
                    return -1;
                else if ((int)o1.getName().toLowerCase().charAt(0) > (int)o2.getName().toLowerCase().charAt(0))
                    return 1;
                else return 0;
            }});

        for (SocialNetWork f : s)
            System.out.println(f.getName());

    }
}
