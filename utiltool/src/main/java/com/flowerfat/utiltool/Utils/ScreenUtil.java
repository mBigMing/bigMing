package com.flowerfat.utiltool.Utils;

import android.content.Context;
import android.util.DisplayMetrics;


public class ScreenUtil {

    public static int[] getScreenSize(Context context) {
        int[] screens;
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        screens = new int[]{dm.widthPixels, dm.heightPixels};
        return screens;
    }





}
