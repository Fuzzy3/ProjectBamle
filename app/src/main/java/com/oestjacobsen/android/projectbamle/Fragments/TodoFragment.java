package com.oestjacobsen.android.projectbamle.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oestjacobsen.android.projectbamle.R;


public class TodoFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.todo_fragment, container, false);

        TextView todoText = (TextView) view.findViewById(R.id.todoText);
        todoText.setText("TODO-SCREEN");


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

}
