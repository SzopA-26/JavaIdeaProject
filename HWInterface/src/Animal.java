public class Animal implements Comparable<Animal>{
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Animal o) {
        if (this.getAge() < o.getAge()) return -1;
        else if (this.getAge() > o.getAge()) return 1;
        return 0;
    }
}
