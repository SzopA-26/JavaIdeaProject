package Exception;

import java.io.FileNotFoundException;

public class MainProgram {
    public static void main(String[] args) {
        FinalExam finalExam = new FinalExam();

        try {
            finalExam.methodA(101);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            finalExam.methodB("AAABBBCCCDDD");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            finalExam.methodC("PokemonSword_full_version_cracked_rom7z");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            finalExam.methodD(null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            finalExam.methodE(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
