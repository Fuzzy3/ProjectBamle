package com.oestjacobsen.android.projectbamle.ViewModels;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

import com.oestjacobsen.android.projectbamle.Model.Note;

public class NoteViewModel extends BaseObservable{
    private final Activity mActivity;
    private Note mNote;

    public NoteViewModel(Activity activity) {
        mActivity = activity;

    }

    @Bindable
    public Note getNote() {
        return mNote;
    }


    public void setNote(Note note) {
        mNote = note;
        notifyChange();
    }

    @Bindable
    public String getName() {
        return mNote.getName();
    }

    public void onNoteClicked(View v) {
        Toast.makeText(mActivity, mNote.getName() + " PRESSED!!", Toast.LENGTH_SHORT).show();

    }
}
