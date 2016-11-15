package com.oestjacobsen.android.projectbamle.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oestjacobsen.android.projectbamle.Model.Task;
import com.oestjacobsen.android.projectbamle.Model.TaskLab;
import com.oestjacobsen.android.projectbamle.Model.TaskType;
import com.oestjacobsen.android.projectbamle.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class TodayFragment extends Fragment {

    //private TodayFragmentBinding mTodayBinding;

    private List<Task> mTodayTasks;

    @BindView(R.id.todayRecyclerView) RecyclerView mTodayRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //mTodayBinding = DataBindingUtil.inflate(inflater, R.layout.today_fragment, container, false);
        //View v = mTodayBinding.getRoot();
        View v = inflater.inflate(R.layout.today_fragment, container, false);
        ButterKnife.bind(this, v);
        updateUI();
        return v;
    }

    public static TodayFragment newInstance() {
        TodayFragment fragment_today = new TodayFragment();
        return fragment_today;
    }

    private void updateUI() {
        fillTodayNotes();

        SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();
        sectionAdapter.addSection(new TodoSection(getActivity(), mTodayTasks));
        sectionAdapter.addSection(new DoneSection(getActivity(), mTodayTasks));

        mTodayRecyclerView.setAdapter(sectionAdapter);
        mTodayRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void fillTodayNotes() {
        TaskLab taskLab = TaskLab.get(getActivity());
        mTodayTasks = new ArrayList<>();
        for(Task task : taskLab.getTasks()) {
            if(task.getType() == TaskType.Today)  {
                mTodayTasks.add(task);
            }
        }

    }
}
