package com.oestjacobsen.android.projectbamle.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.oestjacobsen.android.projectbamle.Model.TaskDbSchema.NoteTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskLab {
    List<Task> mTasks = new ArrayList<>();
    private static TaskLab sTaskLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static TaskLab get(Context context) {
        if (sTaskLab == null) {
            sTaskLab = new TaskLab(context);
        }
        return sTaskLab;
    }

    private TaskLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new TaskDbHelper(mContext).getWritableDatabase();

        for(int i = 0; i < 50; i++) {
            Task note = new Task();
            note.setTitle("Task" + i);
            switch (i % 3) {
                case 0:
                    note.setType(TaskType.Today);
                    break;
                case 1:
                    note.setType(TaskType.Todo);
                    break;
                case 2:
                    note.setType(TaskType.History);
                    break;
            }
            mTasks.add(note);
        }
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public Task getTask(UUID uuid) {
        return null;
    }

    private static ContentValues getContentValues(Task task) {
        ContentValues values = new ContentValues();
        values.put(NoteTable.Cols.UUID, task.getUUID().toString());
        values.put(NoteTable.Cols.TITLE, task.getTitle());
        values.put(NoteTable.Cols.TYPE, task.getType().name());
        return values;
    }

    public void addTask(Task task) {
        ContentValues values = getContentValues(task);
        mDatabase.insert(NoteTable.NAME, null, values);
    }

    public void updateTask(Task task) {
        String uuidString = task.getUUID().toString();
        ContentValues values = getContentValues(task);

        mDatabase.update(NoteTable.NAME, values,
                NoteTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

}
