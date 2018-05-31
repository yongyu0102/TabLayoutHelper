package com.example.administrator.tablelayoutdemo;

import android.support.design.widget.TabLayout;

/**
 * hello
 * Created by pz on 2018/5/31.
 */

public class TabLayoutHelper {
    private Builder builder;

    public TabLayoutHelper(Builder builder){
        this.builder=builder;
        init();
    }

    private void init() {
        if(builder.getTabLayout()==null)return;
    }


    public static class Builder{
        private int selectedTextColor;
        private int normalTextColor;
        private int SelectedBackgroundColor;
        private boolean selectedBold;
        private int indicatorWith;
        private int indicatorHeight;
        private int indicatorColor;
        private int tabItemWith;
        private int tabItemMarginRight;
        private int tabItemMarginLeft;
        private TabLayout tabLayout;

        public Builder(TabLayout tabLayout){
            this.tabLayout=tabLayout;
        }

        public TabLayout getTabLayout(){
            return tabLayout;
        }

        public int getSelectedTextColor() {
            return selectedTextColor;
        }

        public Builder setSelectedTextColor(int selectedTextColor) {
            this.selectedTextColor = selectedTextColor;
            return this;
        }

        public int getNormalTextColor() {
            return normalTextColor;
        }

        public Builder setNormalTextColor(int normalTextColor) {
            this.normalTextColor = normalTextColor;
            return this;
        }

        public int getSelectedBackgroundColor() {
            return SelectedBackgroundColor;
        }

        public Builder setSelectedBackgroundColor(int selectedBackgroundColor) {
            SelectedBackgroundColor = selectedBackgroundColor;
            return this;
        }

        public boolean isSelectedBold() {
            return selectedBold;
        }

        public Builder setSelectedBold(boolean selectedBold) {
            this.selectedBold = selectedBold;
            return this;
        }

        public int getIndicatorWith() {
            return indicatorWith;
        }

        public Builder setIndicatorWith(int indicatorWith) {
            this.indicatorWith = indicatorWith;
            return this;
        }

        public int getIndicatorHeight() {
            return indicatorHeight;
        }

        public Builder setIndicatorHeight(int indicatorHeight) {
            this.indicatorHeight = indicatorHeight;
            return this;
        }

        public int getIndicatorColor() {
            return indicatorColor;
        }

        public Builder setIndicatorColor(int indicatorColor) {
            this.indicatorColor = indicatorColor;
            return this;
        }

        public int getTabItemWith() {
            return tabItemWith;
        }

        public Builder setTabItemWith(int tabItemWith) {
            this.tabItemWith = tabItemWith;
            return this;
        }

        public int getTabItemMarginRight() {
            return tabItemMarginRight;
        }

        public Builder setTabItemMarginRight(int tabItemMarginRight) {
            this.tabItemMarginRight = tabItemMarginRight;
            return this;
        }

        public int getTabItemMarginLeft() {
            return tabItemMarginLeft;
        }

        public Builder setTabItemMarginLeft(int tabItemMarginLeft) {
            this.tabItemMarginLeft = tabItemMarginLeft;
            return this;
        }

        public TabLayoutHelper build(){
            return new TabLayoutHelper(this);
        }
    }
}
