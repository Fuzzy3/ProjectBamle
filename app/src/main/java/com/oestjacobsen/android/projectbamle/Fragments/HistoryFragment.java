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


public class HistoryFragment extends Fragment {
    private List<Task> mHistoryTasks;
    @BindView(R.id.historyRecyclerView) RecyclerView mHistoryRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.history_fragment, container, false);
        ButterKnife.bind(this, v);

        updateUI();

        return v;
    }

    public static HistoryFragment newInstance() {
        HistoryFragment fragment_history = new HistoryFragment();
        return fragment_history;
    }

    public void updateUI() {
        fillHistoryNotes();
        TasksAdapter adapter = new TasksAdapter(getActivity(), mHistoryTasks);
        mHistoryRecyclerView.setAdapter(adapter);
        mHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void fillHistoryNotes() {
        mHistoryTasks = new ArrayList<>();
        TaskLab taskLab = TaskLab.get(getActivity());
        for (Task task : taskLab.getTasks()) {
            if(task.getType() == TaskType.History) {
                mHistoryTasks.add(task);
            }
        }
    }
}
