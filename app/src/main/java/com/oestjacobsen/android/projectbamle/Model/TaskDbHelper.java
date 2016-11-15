package com.oestjacobsen.android.projectbamle.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.oestjacobsen.android.projectbamle.Model.TaskDbSchema.NoteTable;

/**
 * Created by mr_oj on 10/11/2016.
 */

public class TaskDbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATAABASE_NAME = "noteBase.db";

    public TaskDbHelper(Context context) {
        super(context, DATAABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + NoteTable.NAME +
                "(" + " _id integer primary key autoincrement, " +
                NoteTable.Cols.UUID + ", " +
                NoteTable.Cols.TITLE + ", " +
                NoteTable.Cols.TYPE +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
