package com.oestjacobsen.android.projectbamle.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.oestjacobsen.android.projectbamle.Model.NoteDbSchema.NoteTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoteLab {
    private static NoteLab sNoteLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static NoteLab get(Context context) {
        if (sNoteLab == null) {
            sNoteLab = new NoteLab(context);
        }
        return sNoteLab;
    }

    private NoteLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new NoteDbHelper(mContext).getWritableDatabase();

        /*for(int i = 0; i < 50; i++) {
            Note note = new Note();
            note.setName("Note" + i);
            switch (i % 3) {
                case 0:
                    note.setType(NoteType.Today);
                    break;
                case 1:
                    note.setType(NoteType.Todo);
                    break;
                case 2:
                    note.setType(NoteType.History);
                    break;
            }
            mNotes.add(note);
        }*/
    }

    public List<Note> getNotes() {
        return new ArrayList<>();
    }

    public Note getNote(UUID uuid) {
        return null;
    }

    private static ContentValues getContentValues(Note note) {
        ContentValues values = new ContentValues();
        values.put(NoteTable.Cols.UUID, note.getUUID().toString());
        values.put(NoteTable.Cols.TITLE, note.getName());
        values.put(NoteTable.Cols.TYPE, note.getType().name());
        return values;
    }

    public void addNote(Note note) {
        ContentValues values = getContentValues(note);
        mDatabase.insert(NoteTable.NAME, null, values);
    }

    public void updateNote(Note note) {
        String uuidString = note.getUUID().toString();
        ContentValues values = getContentValues(note);

        mDatabase.update(NoteTable.NAME, values,
                NoteTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }
    
}
