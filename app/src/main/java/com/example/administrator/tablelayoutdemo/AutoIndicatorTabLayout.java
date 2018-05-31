package com.example.administrator.tablelayoutdemo;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * hello
 * Created by pz on 2018/5/31.
 */

public class AutoIndicatorTabLayout extends TabLayout {
    private Context context;
    private int selectedTextColor;
    private int normalTextColor;
    private int backGroundColor;
    private boolean selectedBold;
    public AutoIndicatorTabLayout(Context context) {
        this(context,null);
    }

    public AutoIndicatorTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AutoIndicatorTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public AutoIndicatorTabLayout setSelectedTextColor(int color){
      this.selectedTextColor=color;
      return this;
    }

    private int getSelectedTextColor(){
        return selectedTextColor;
    }

    public AutoIndicatorTabLayout setNormalTextColor(int color){
        this.normalTextColor=color;
        return this;
    }

    public AutoIndicatorTabLayout setTabItemBackGroundColor(int color){
        this.backGroundColor=backGroundColor;
        return this;
    }

    public AutoIndicatorTabLayout setSelectedBold(boolean bold){
        this.selectedBold=bold;
        return this;
    }



    private int getNormalTextColor() {
        return normalTextColor;
    }

    private int getBackGroundColor() {
        return backGroundColor;
    }



    private boolean isSelectedBold() {
        return selectedBold;
    }


    private void init(Context context){
        setSelectedTabIndicatorHeight(0);
            addOnTabSelectedListener(new OnTabSelectedListener() {
                @Override
                public void onTabSelected(Tab tab) {
                    if(tab.getCustomView()==null)return;
                    TextView textView = tab.getCustomView().findViewById(R.id.tv_tab);
                    textView.setTextColor(getSelectedTextColor());
                    if(isSelectedBold()){
                        textView .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    }
                    tab.getCustomView().findViewById(R.id.view_indicator).setVisibility(View.VISIBLE);
                }

                @Override
                public void onTabUnselected(Tab tab) {
                    if(tab.getCustomView()==null)return;
                    TextView textView = tab.getCustomView().findViewById(R.id.tv_tab);
                    textView.setTextColor(getNormalTextColor());
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    tab.getCustomView().findViewById(R.id.view_indicator).setVisibility(View.GONE);
                }

                @Override
                public void onTabReselected(Tab tab) {

                }
            });
    }

    public void setTabIndicatorMargin(final int rightMargin, final int leftMargin) {
        post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout childAt = (LinearLayout) getChildAt(0);
                    for (int j = 0; j < childAt.getChildCount(); j++) {
                        TabLayout.Tab tab = getTabAt(j);
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
        });
    }

    public void setTabItemWith(final int with){
        post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout childAt = (LinearLayout) getChildAt(0);
                    for (int j = 0; j < childAt.getChildCount(); j++) {
                        TabLayout.Tab tab = getTabAt(j);
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
      post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout childAt = (LinearLayout) getChildAt(0);
                    if(pos>=childAt.getChildCount())return;
                    TabLayout.Tab tab = getTabAt(pos);
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

    public void setIndicatorWith(final int with){
        post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout childAt = (LinearLayout) getChildAt(0);
                    for (int j = 0; j < childAt.getChildCount(); j++) {
                        TabLayout.Tab tab = getTabAt(j);
                        if(tab==null)return;
                        View customView = tab.getCustomView();
                        if(customView==null)return;
                        View indicator=customView.findViewById(R.id.view_indicator);
                        ViewGroup.LayoutParams layoutParams = indicator.getLayoutParams();
                        layoutParams.width=with;
                        indicator.setLayoutParams(layoutParams);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void setIndicatorColor(final int color){
        post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout childAt = (LinearLayout) getChildAt(0);
                    for (int j = 0; j < childAt.getChildCount(); j++) {
                        TabLayout.Tab tab = getTabAt(j);
                        if(tab==null)return;
                        View customView = tab.getCustomView();
                        if(customView==null)return;
                        View indicator=customView.findViewById(R.id.view_indicator);
                        indicator.setBackgroundColor(color);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public static class Builder{
        private int selectedTextColor;
        private int normalTextColor;
        private int backGroundColor;
        private boolean selectedBold;
    }

}
