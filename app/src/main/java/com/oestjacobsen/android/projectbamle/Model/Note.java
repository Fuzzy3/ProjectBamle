package com.oestjacobsen.android.projectbamle.Model;


import java.util.ArrayList;
import java.util.UUID;

public class Note {

    private String mName = "NoName";
    private final UUID mId;

    public Note() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }


    public static ArrayList<Note> generateNotes(int count){
        ArrayList<Note> Notes = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            Note note = new Note();
            note.setName("Note" + i);
            Notes.add(note);
        }
        return Notes;
    }
}
