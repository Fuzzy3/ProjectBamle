package com.oestjacobsen.android.projectbamle.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oestjacobsen.android.projectbamle.Model.Note;
import com.oestjacobsen.android.projectbamle.Model.NoteLab;
import com.oestjacobsen.android.projectbamle.Model.NoteType;
import com.oestjacobsen.android.projectbamle.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TodoFragment extends Fragment {
    List<Note> mTodoNotes;
    @BindView(R.id.todoText) TextView mTodoText;
    @BindView(R.id.todoRecyclerView) RecyclerView mTodoRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.todo_fragment, container, false);
        ButterKnife.bind(this, view);

        mTodoText.setText("TODO-SCREEN");

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
        NotesAdapter adapter = new NotesAdapter(getActivity(), mTodoNotes);
        mTodoRecyclerView.setAdapter(adapter);
        mTodoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void fillTodoNotes() {
        mTodoNotes = new ArrayList<>();
        NoteLab noteLab = NoteLab.get(getActivity());
        for (Note note : noteLab.getNotes()) {
            if(note.getType() == NoteType.Todo) {
                mTodoNotes.add(note);
            }
        }

    }

}
