package com.example.pz.tab;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] titles = {"体育", "新闻", "好看福利", "新闻2"};
//    private String[] titles = {"体育",  "好看福利"};
    private HomeVideoFragmentAdapter homeVideoFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        fragmentList.add(TabFragment.getInstance(Color.BLUE));
        fragmentList.add(TabFragment.getInstance(Color.GREEN));
        fragmentList.add(TabFragment.getInstance(Color.YELLOW));
        fragmentList.add(TabFragment.getInstance(Color.BLUE));
        homeVideoFragmentAdapter = new HomeVideoFragmentAdapter(getSupportFragmentManager(), fragmentList, titles);
        viewPager.setAdapter(homeVideoFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        setTabLayout();
    }


    private void setTabLayout() {
        new TabLayoutHelper.Builder(tabLayout)
                .setIndicatorColor(Color.BLUE)
                .setIndicatorHeight(6)
                .setIndicatorWith(100)
                .setTabItemMarginLeft(20)
                .setIndicatorDrawable(R.drawable.bg_tab_red)
                .setNormalTextColor(Color.GRAY)
                .setSelectedTextColor(Color.RED)
                .setSelectedBold(true)
                .setIndicatorMargin(40)
//                .setTabItemWith(300)
                .setTabItemPadding(20)
//                .setSelectedBackgroundColor(Color.YELLOW)
//                .setNormalBackgroundColor(Color.DKGRAY)
                .setTabItemMarginLeft(20)
                .build();
    }


    private void initView() {
        tabLayout = findViewById(R.id.tb_bar);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }

}
