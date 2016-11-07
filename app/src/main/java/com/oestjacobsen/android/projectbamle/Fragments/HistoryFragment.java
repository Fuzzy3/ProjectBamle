package com.oestjacobsen.android.projectbamle.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oestjacobsen.android.projectbamle.R;


public class HistoryFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.history_fragment, container, false);

        TextView historyText = (TextView) v.findViewById(R.id.historyText);
        historyText.setText("HISTORY-SCREEN");

        return v;
    }

    public static HistoryFragment newInstance() {
        HistoryFragment fragment_history = new HistoryFragment();
        return fragment_history;
    }
}
