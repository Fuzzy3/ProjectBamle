package com.oestjacobsen.android.projectbamle.Model;


import java.util.Date;
import java.util.UUID;

public class Task {

    private String mTitle = "NoName";
    private String mTag;
    private int mPriority;
    private Date mDate;
    private String mDetails;
    private final UUID mUUID;
    private TaskType mType;
    private boolean mIsDone;

    public boolean isDone() {
        return mIsDone;
    }

    public void setDone(boolean done) {
        mIsDone = done;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setType(TaskType type) {
        mType = type;
    }

    public TaskType getType() {
        return mType;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getDetails() {
        return mDetails;
    }

    public void setDetails(String details) {
        mDetails = details;
    }

    public Task() {
        mUUID = UUID.randomUUID();
    }



}
