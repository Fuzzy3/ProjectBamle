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


public class TodoFragment extends Fragment {
    List<Task> mTodoTasks;
    @BindView(R.id.todoRecyclerView) RecyclerView mTodoRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.todo_fragment, container, false);
        ButterKnife.bind(this, view);


        updateUI();
        return view;
    }

    // newInstance constructor for creating fragment with arguments
    public static TodoFragment newInstance() {
        TodoFragment fragmentTodo = new TodoFragment();
        /*Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);*/
        return fragmentTodo;
    }

    private void updateUI() {
        fillTodoNotes();
        TasksAdapter adapter = new TasksAdapter(getActivity(), mTodoTasks);
        mTodoRecyclerView.setAdapter(adapter);
        mTodoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void fillTodoNotes() {
        mTodoTasks = new ArrayList<>();
        TaskLab taskLab = TaskLab.get(getActivity());
        for (Task task : taskLab.getTasks()) {
            if(task.getType() == TaskType.Todo) {
                mTodoTasks.add(task);
            }
        }

    }

}
