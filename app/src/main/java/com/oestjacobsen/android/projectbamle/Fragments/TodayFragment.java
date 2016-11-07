package com.oestjacobsen.android.projectbamle.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oestjacobsen.android.projectbamle.R;

public class TodayFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.today_fragment, container, false);

        TextView todayText = (TextView) v.findViewById(R.id.todayText);
        todayText.setText("TODAY-SCREEN");

        return v;
    }

    public static TodayFragment newInstance() {
        TodayFragment fragment_today = new TodayFragment();
        return fragment_today;
    }
}
