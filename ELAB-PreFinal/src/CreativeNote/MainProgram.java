package CreativeNote;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Melody melody = new Melody();
        Scanner sc = new Scanner(System.in);
        int nNote = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<nNote; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j=0; j<Integer.parseInt(line[2]); j++) {
                if (line[0].equals("Normal"))
                    melody.addNote(new Note(line[1].charAt(0)));
                else melody.addNote(new Creative(line[1].charAt(0)));
            }
        }

        int nPlay = sc.nextInt();
        for (int i=0; i<nPlay; i++) {
            System.out.println(melody.getNotes());
        }
    }
}
