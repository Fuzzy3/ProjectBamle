package com.oestjacobsen.android.projectbamle.Model;


import java.util.ArrayList;

public class Note {

    private String mName;

    public Note(String name) {
        mName = name;
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
            Notes.add(new Note("Note" + i));
        }
        return Notes;
    }
}
