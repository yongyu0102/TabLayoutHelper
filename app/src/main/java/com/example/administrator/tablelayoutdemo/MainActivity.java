package com.example.administrator.tablelayoutdemo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AutoIndicatorTabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList=new ArrayList<>();
    private String [] titles={"体育","新闻","好看福利"};
    private HomeVideoFragmentAdapter homeVideoFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        fragmentList.add(TabFragment.getInstance());
        fragmentList.add(TabFragment.getInstance());
        fragmentList.add(TabFragment.getInstance());
        homeVideoFragmentAdapter=new HomeVideoFragmentAdapter(getSupportFragmentManager(),fragmentList,titles);
        viewPager.setAdapter(homeVideoFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.setTabIndicatorMargin(20,20);
        tabLayout.setNormalTextColor(Color.BLACK)
                .setSelectedTextColor(Color.RED)
                .setSelectedBold(true)
                .setTabItemWith(300);

        tabLayout.setIndicatorColor(Color.BLUE);
        tabLayout.setIndicatorWith(100);

//        setIndicator();
    }

    private void setIndicator() {
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                setTabIndicatorWith(tabLayout,20,20);
            }
        });

        setTabItemWith(170);
        setTabItemWithPosition(300,2);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab);
                textView.setTextColor(getResources().getColor(R.color.color_000000));
                textView .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                tab.getCustomView().findViewById(R.id.view_indicator).setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab);
                textView.setTextColor(getResources().getColor(R.color.color_797979));
                textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tab.getCustomView().findViewById(R.id.view_indicator).setVisibility(View.GONE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initView(){
        tabLayout =  findViewById(R.id.tb_bar);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }


    private void setTabIndicatorWith(TabLayout tabLayout,int rightMargin,int leftMargin) {
        try {
            LinearLayout childAt = (LinearLayout) tabLayout.getChildAt(0);
            for (int j = 0; j < childAt.getChildCount(); j++) {
                TabLayout.Tab tab = tabLayout.getTabAt(j);
                if(tab==null)return;
                CharSequence text = tab.getText();
                tab.setCustomView(R.layout.item_tab_view);
                TextView textView = (TextView) tab.getCustomView().findViewById(R.id.tv_tab);
                textView.setText(text);
                if(j==0){
                    textView.setTextColor(getResources().getColor(R.color.color_000000));
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    tab.getCustomView().findViewById(R.id.view_indicator).setVisibility(View.VISIBLE);
                }
                //这里为0跟字体宽度一样，可以加长
                childAt.getChildAt(j).setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt
                        .getChildAt(j).getLayoutParams();
                //为了对称，可以判断j=0时设置向左间距
                //向右间距
                layoutParams.rightMargin = leftMargin;
                layoutParams.leftMargin = rightMargin;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setTabItemWith(final int with){
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout childAt = (LinearLayout) tabLayout.getChildAt(0);
                    for (int j = 0; j < childAt.getChildCount(); j++) {
                        TabLayout.Tab tab = tabLayout.getTabAt(j);
                        if(tab==null)return;
                        View customView = tab.getCustomView();
                        if(customView==null)return;
                        ViewGroup.LayoutParams layoutParams = customView.getLayoutParams();
                        layoutParams.width=with;
                        customView.setLayoutParams(layoutParams);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void setTabItemWithPosition(final int with, final int pos){
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout childAt = (LinearLayout) tabLayout.getChildAt(0);
                    if(pos>=childAt.getChildCount())return;
                        TabLayout.Tab tab = tabLayout.getTabAt(pos);
                        if(tab==null)return;
                        View customView = tab.getCustomView();
                        if(customView==null)return;
                        ViewGroup.LayoutParams layoutParams = customView.getLayoutParams();
                        layoutParams.width=with;
                        customView.setLayoutParams(layoutParams);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
