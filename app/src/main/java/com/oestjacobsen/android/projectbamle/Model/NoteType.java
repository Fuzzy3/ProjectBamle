package com.oestjacobsen.android.projectbamle.Model;

/**
 * Created by mr_oj on 10/11/2016.
 */

public enum NoteType {
    Today(0),
    Todo(1),
    History(2);

    private int mType;

    NoteType(int type) {
        this.mType = type;
    }

    public int getType() {
        return mType;
    }
}
