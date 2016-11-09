package com.oestjacobsen.android.projectbamle.Fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oestjacobsen.android.projectbamle.Model.Note;
import com.oestjacobsen.android.projectbamle.R;
import com.oestjacobsen.android.projectbamle.databinding.TodayFragmentBinding;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TodayFragment extends Fragment {

    //private TodayFragmentBinding mTodayBinding;

    private ArrayList<Note> mTodayNotes;

    @BindView(R.id.todayText) TextView mTodayText;
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



        mTodayNotes = Note.generateNotes(30);
        NotesAdapter adapter = new NotesAdapter(getActivity(), mTodayNotes);
        mTodayRecyclerView.setAdapter(adapter);
        mTodayRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mTodayText.setText("TODAY-SCREEN");
        return v;
    }

    public static TodayFragment newInstance() {
        TodayFragment fragment_today = new TodayFragment();
        return fragment_today;
    }
}
