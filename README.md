this is used to set indicator's style of tabLayout in Android

![tablayout](https://github.com/yongyu0102/WeeklyBlogImages/blob/master/tablayout/tablayout.gif?raw=true)

use:

```java
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
               .setTabItemWith(300)
                .setTabItemPadding(20)
                .setSelectedBackgroundColor(Color.YELLOW)
              .setNormalBackgroundColor(Color.DKGRAY)
                .setTabItemMarginLeft(20)
                .build();
    }
```

详情见博客地址： [TabLayout 自定义 Indicator 指示线宽度样式](https://yongyu.itscoder.com/2018/06/03/yongyu_20180502_tablayout_helper/) 