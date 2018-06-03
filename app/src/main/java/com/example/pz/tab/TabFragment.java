package com.example.pz.tab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * hello
 * Created by pz on 2018/5/31.
 */

public class TabFragment extends Fragment {
    private static final String KEY="key";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        Bundle arguments = getArguments();
        if(arguments!=null) {
            int color = arguments.getInt(KEY);
            view.setBackgroundColor(color);
        }
        return view;
    }


    public static TabFragment getInstance(int backGroundColor){
        Bundle bundle=new Bundle();
        bundle.putInt(KEY,backGroundColor);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }
}
