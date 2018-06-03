package com.example.library.helper;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.library.R;

/**
 * hello
 * Created by pz on 2018/5/31.
 */

public class TabLayoutHelper {
    private Builder builder;

    private TabLayoutHelper(Builder builder) {
        this.builder = builder;
        init();
    }

    private void init() {
        if (builder.getTabLayout() == null) return;
        TabLayout tabLayout = builder.getTabLayout();
        tabLayout.setSelectedTabIndicatorHeight(0);
        initView(tabLayout);
        initListener(tabLayout);
    }

    private void initListener(TabLayout tabLayout) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getCustomView() == null) return;
                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab);
                if (builder.getSelectedTextColor() != 0) {
                    textView.setTextColor(builder.getSelectedTextColor());
                }
                if (builder.isSelectedBold()) {
                    textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                }
                if (builder.getSelectedBackgroundColor() != 0) {
                    textView.setBackgroundColor(builder.getSelectedBackgroundColor());
                }
                tab.getCustomView().findViewById(R.id.view_indicator).setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getCustomView() == null) return;
                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab);
                if (builder.getNormalTextColor() != 0) {
                    textView.setTextColor(builder.getNormalTextColor());
                }
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                if(builder.getNormalBackgroundColor()!=0){
                    textView.setBackgroundColor(builder.getNormalBackgroundColor());
                }
                tab.getCustomView().findViewById(R.id.view_indicator).setVisibility(View.GONE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initView(final TabLayout tabLayout) {
        builder.getTabLayout().post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout childAt = (LinearLayout) tabLayout.getChildAt(0);
                    for (int j = 0; j < childAt.getChildCount(); j++) {
                        TabLayout.Tab tab = tabLayout.getTabAt(j);
                        if (tab == null) return;
                        CharSequence text = tab.getText();
                        tab.setCustomView(R.layout.item_tab_view);
                        if (tab.getCustomView() == null) return;
                        View customView = tab.getCustomView();
                        TextView textView = (TextView) customView.findViewById(R.id.tv_tab);
                        textView.setText(text);
                        if(builder.getNormalBackgroundColor()!=0){
                            textView.setBackgroundColor(builder.getNormalBackgroundColor());
                        }

                        View indicator = customView.findViewById(R.id.view_indicator);
                        if (j == 0) {
                            int color = builder.getSelectedTextColor();
                            if (color == 0) {
                                color = Color.BLACK;
                            }
                            textView.setTextColor(color);
                            if (builder.isSelectedBold()) {
                                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                            }
                            if (builder.getSelectedBackgroundColor() != 0) {
                                textView.setBackgroundColor(builder.getSelectedBackgroundColor());
                            }
                            indicator.setVisibility(View.VISIBLE);
                        }
                        FrameLayout.LayoutParams indicatorLayout = (FrameLayout.LayoutParams) indicator.getLayoutParams();
                        if (builder.getIndicatorWith() != 0) {
                            indicatorLayout.width = builder.getIndicatorWith();
                        }
                        if (builder.getIndicatorHeight() != 0) {
                            indicatorLayout.height = builder.getIndicatorHeight();
                        }
                        if (builder.getIndicatorColor() != 0) {
                            indicator.setBackgroundColor(builder.getIndicatorColor());
                        }

                        if(builder.getIndicatorMargin()!=0){
                            indicatorLayout.rightMargin=builder.getIndicatorMargin();
                            indicatorLayout.leftMargin=builder.getIndicatorMargin();
                        }

                        if(builder.getIndicatorDrawable()!=0){
                            indicator.setBackgroundResource(builder.getIndicatorDrawable());
                        }

                        childAt.getChildAt(j).setPadding(builder.getTabItemPadding(), 0, builder.getTabItemPadding(), 0);
                        LinearLayout.LayoutParams lLayoutParams = (LinearLayout.LayoutParams) childAt
                                .getChildAt(j).getLayoutParams();
                        lLayoutParams.rightMargin = builder.getTabItemMarginRight();
                        lLayoutParams.leftMargin = builder.getTabItemMarginLeft();
                        if (builder.getTabItemWith() != 0) {
                            lLayoutParams.width = builder.getTabItemWith();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }


    public static class Builder {
        private int selectedTextColor;
        private int normalTextColor;
        private int normalBackgroundColor;
        private int SelectedBackgroundColor;
        private boolean selectedBold;
        private int indicatorWith;
        private int indicatorHeight;
        private int indicatorColor;
        private int indicatorDrawable;
        private int indicatorMargin;
        private int tabItemWith;
        private int tabItemPadding;
        private int tabItemMarginRight;
        private int tabItemMarginLeft;
        private TabLayout tabLayout;

        public int getTabItemPadding() {
            return tabItemPadding;
        }

        public Builder setTabItemPadding(int tabItemPadding) {
            this.tabItemPadding = tabItemPadding;
            return this;
        }

        public Builder(TabLayout tabLayout) {
            this.tabLayout = tabLayout;
        }

        private TabLayout getTabLayout() {
            return tabLayout;
        }

        private int getSelectedTextColor() {
            return selectedTextColor;
        }

        public Builder setSelectedTextColor(int selectedTextColor) {
            this.selectedTextColor = selectedTextColor;
            return this;
        }

        private int getIndicatorMargin() {
            return indicatorMargin;
        }

        public Builder setIndicatorMargin(int indicatorMargin) {
            this.indicatorMargin = indicatorMargin;
            return this;
        }

        private int getIndicatorDrawable() {
            return indicatorDrawable;
        }

        public Builder setIndicatorDrawable(int indicatorDrawable) {
            this.indicatorDrawable = indicatorDrawable;
            return this;
        }

        private int getNormalBackgroundColor() {
            return normalBackgroundColor;
        }

        public Builder setNormalBackgroundColor(int normalBackgroundColor) {
            this.normalBackgroundColor = normalBackgroundColor;
            return this;
        }

        private int getNormalTextColor() {
            return normalTextColor;
        }

        public Builder setNormalTextColor(int normalTextColor) {
            this.normalTextColor = normalTextColor;
            return this;
        }

        private int getSelectedBackgroundColor() {
            return SelectedBackgroundColor;
        }

        public Builder setSelectedBackgroundColor(int selectedBackgroundColor) {
            SelectedBackgroundColor = selectedBackgroundColor;
            return this;
        }

        private boolean isSelectedBold() {
            return selectedBold;
        }

        public Builder setSelectedBold(boolean selectedBold) {
            this.selectedBold = selectedBold;
            return this;
        }

        private int getIndicatorWith() {
            return indicatorWith;
        }

        public Builder setIndicatorWith(int indicatorWith) {
            this.indicatorWith = indicatorWith;
            return this;
        }

        private int getIndicatorHeight() {
            return indicatorHeight;
        }

        public Builder setIndicatorHeight(int indicatorHeight) {
            this.indicatorHeight = indicatorHeight;
            return this;
        }

        private int getIndicatorColor() {
            return indicatorColor;
        }

        public Builder setIndicatorColor(int indicatorColor) {
            this.indicatorColor = indicatorColor;
            return this;
        }

        private int getTabItemWith() {
            return tabItemWith;
        }

        public Builder setTabItemWith(int tabItemWith) {
            this.tabItemWith = tabItemWith;
            return this;
        }

        private int getTabItemMarginRight() {
            return tabItemMarginRight;
        }

        public Builder setTabItemMarginRight(int tabItemMarginRight) {
            this.tabItemMarginRight = tabItemMarginRight;
            return this;
        }

        private int getTabItemMarginLeft() {
            return tabItemMarginLeft;
        }

        public Builder setTabItemMarginLeft(int tabItemMarginLeft) {
            this.tabItemMarginLeft = tabItemMarginLeft;
            return this;
        }

        public TabLayoutHelper build() {
            return new TabLayoutHelper(this);
        }
    }
}
