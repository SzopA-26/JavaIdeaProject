import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("(Z)ee",101));
        students.add(new Student("Tee",23));
        students.add(new Student("Sern",24));
        students.add(new Student("Nob",20));
        students.add(new Student("Zee",100));

        Student studentMaxScore = Data.max(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore()>o2.getScore()? 1 : 0;
            }
        });
        Student lastStudent = Data.max(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(studentMaxScore);
        System.out.println(lastStudent);
    }
}
