package com.example.administrator.tablelayoutdemo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * hello
 * Created by pz on 2018/5/28.
 */

public class HomeVideoFragmentAdapter extends FragmentStatePagerAdapter {

    private String[] titles;
    private List<Fragment> fragments;
    public HomeVideoFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] titles) {
        super(fm);
        this.titles=titles;
        this.fragments=fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
