public class Program {
    static void p(String s){ System.out.println(s);}
    public static void main(String[] args) {
        String[]s={"Baby","Mommy","Daddy","Grandma","Grandpa","Let's go hunt"};
        String d="doo doo doo doo doo doo";
        for(String i:s){
            if(!i.equals(s[5])) i+=" shark";
            for(int j=0;j<3;j++) p(i+", "+d);
            p(i+"!");
        }p("Run away,...");
    }
}
