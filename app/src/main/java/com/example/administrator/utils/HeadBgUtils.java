package com.example.administrator.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class HeadBgUtils {
    // 使用此方法需要在相应界面布局的头部添加一个全透明的view，高度为状态栏高度24dp
    // <View
    // android:layout_width="match_parent"
    // android:layout_height="24dp"
    // android:background="#00000000" />

    // 使界面加载从状态栏起点开始
    @SuppressLint("NewApi")
    public static void headTransparent(Activity activity) {
        if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            // 清除系统提供的默认保护色
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            // 设置系统UI的显示方式
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            // 添加属性可以自定义设置系统工具栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.argb(51, 0, 0, 0));
            // window.setNavigationBarColor(color_navigation_bar);
        }
    }

    // // 设置状态栏中各状态的颜色，true为黑色，false为白色
    // public static void setDarkStatusIcon(Activity activity, boolean bDark) {
    // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    // View decorView = activity.getWindow().getDecorView();
    // if (decorView != null) {
    // int vis = decorView.getSystemUiVisibility();
    // if (bDark) {
    // vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    // } else {
    // vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    // }
    // decorView.setSystemUiVisibility(vis);
    // }
    // }
    // }
}
