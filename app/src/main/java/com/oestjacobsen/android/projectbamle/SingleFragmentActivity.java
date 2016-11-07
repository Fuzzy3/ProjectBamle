package com.oestjacobsen.android.projectbamle;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();
    protected abstract String setTitleString();

    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        setTitle(setTitleString());
        setupFragment();
    }

    private void setupFragment() {
        //Setting up FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.mainContainer);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.mainContainer, fragment).commit();
        }
    }


}
