package com.oestjacobsen.android.projectbamle.Model;


import java.util.ArrayList;
import java.util.UUID;

public class Note {

    private String mName = "NoName";
    private final UUID mUUID;
    private NoteType mType;

    public Note() {
        mUUID = UUID.randomUUID();
    }

    public UUID getUUID() {
        return mUUID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setType(NoteType type) {
        mType = type;
    }

    public NoteType getType() {
        return mType;
    }

}
