public class Program {
    void method1() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        Program p1 = new Program();
        p1.method1();
        Program p2 = new Program() {
            void method1() {
                System.out.println(2);
            }
        };
        p2.method1();
    }
}