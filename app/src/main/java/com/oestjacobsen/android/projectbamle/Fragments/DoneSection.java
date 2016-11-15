package com.oestjacobsen.android.projectbamle.Fragments;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oestjacobsen.android.projectbamle.Model.Task;
import com.oestjacobsen.android.projectbamle.R;
import com.oestjacobsen.android.projectbamle.databinding.TaskItemBinding;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;


public class DoneSection extends StatelessSection {
    private final Activity mActivity;
    boolean expanded = true;
    private List<Task> mTasks;

    public DoneSection(Activity activity, List<Task> tasks) {
        super(R.layout.section_done_header, R.layout.task_item);
        mTasks = tasks;
        mActivity = activity;
    }

    @Override
    public int getContentItemsTotal() {
        return mTasks.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        Context context = view.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        TaskItemBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.task_item, (ViewGroup) view, false);

        SectionViewHolder viewHolder = new SectionViewHolder(binding, mActivity);

        return viewHolder;
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        Task task = mTasks.get(position);
        SectionViewHolder todoSectionHolder = (SectionViewHolder) holder;

        todoSectionHolder.bindTask(task);
    }

}
