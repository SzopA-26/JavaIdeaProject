package CreativeNote;

import java.util.ArrayList;

public class Melody {
    private ArrayList<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public String getNotes() {
        StringBuilder noteStr = new StringBuilder();
        for (Note note : notes)
            noteStr.append(note.getNote());
        return noteStr.toString();
    }
}
