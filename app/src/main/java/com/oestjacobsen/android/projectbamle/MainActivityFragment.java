package com.oestjacobsen.android.projectbamle;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.oestjacobsen.android.projectbamle.Fragments.HistoryFragment;
import com.oestjacobsen.android.projectbamle.Fragments.TodayFragment;
import com.oestjacobsen.android.projectbamle.Fragments.TodoFragment;


public class MainActivityFragment extends Fragment {
    FragmentPagerAdapter viewPagerAdapter;


    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.main_fragment, container, false);

        ViewPager vpPager = (ViewPager) v.findViewById(R.id.vpPager);
        viewPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager(),getActivity());
        vpPager.setAdapter(viewPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.floatingButAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "BUTTON PRESSED!! WOOP", Toast.LENGTH_SHORT).show();
            }
        });

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vpPager);

        return v;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }




    //Adapter
    public class MyPagerAdapter extends FragmentPagerAdapter {
        static final int NUM_TABS = 3;
        private String tabTitles[] = new String[] { "Today", "Todo", "History" };
        private Context context;


        public MyPagerAdapter(FragmentManager fm, Context ct) {
            super(fm);
            context = ct;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TodayFragment.newInstance();
                case 1:
                    return TodoFragment.newInstance();
                case 2:
                    return HistoryFragment.newInstance();
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            return NUM_TABS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
