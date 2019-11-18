package CreativeNote;

import java.util.ArrayList;

public class Creative extends Note {
    private ArrayList<Character> notes = new ArrayList<>();

    public Creative(char note) {
        super(note);
        notes.add('C');
        notes.add('D');
        notes.add('E');
        notes.add('F');
        notes.add('G');
        notes.add('A');
        notes.add('B');
    }

    @Override
    public char getNote() {
        char temp = super.getNote();
        if (super.getNote() == 'B')
            super.setNote('C');
        else super.setNote(notes.get(notes.indexOf(super.getNote()) + 1));
        return temp;
    }
}
