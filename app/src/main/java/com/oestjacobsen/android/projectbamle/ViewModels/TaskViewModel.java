package com.oestjacobsen.android.projectbamle.ViewModels;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

import com.oestjacobsen.android.projectbamle.Model.Task;

public class TaskViewModel extends BaseObservable{
    private final Activity mActivity;
    private Task mTask;

    public TaskViewModel(Activity activity) {
        mActivity = activity;

    }

    @Bindable
    public Task getTask() {
        return mTask;
    }


    public void setTask(Task task) {
        mTask = task;
        notifyChange();
    }

    @Bindable
    public String getTitle() {
        return mTask.getTitle();
    }

    public void onNoteClicked(View v) {
        Toast.makeText(mActivity, mTask.getTitle() + " PRESSED!!", Toast.LENGTH_SHORT).show();

    }
}
