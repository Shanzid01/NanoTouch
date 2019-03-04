package com.slideme.sam.manager.controller.p055b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* compiled from: ScreenUtils */
public abstract class C1705g {
    public static String[] m5078a(Context context, Resources resources) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(resources.getDisplayMetrics());
        return new String[]{String.valueOf(r1.widthPixels), String.valueOf(r1.heightPixels)};
    }

    public static String m5079b(Context context, Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        switch (displayMetrics.densityDpi) {
            case 120:
                return "ldpi";
            case 160:
                return "mdpi";
            case 213:
                return "tvdpi";
            case 240:
                return "hdpi";
            case 320:
                return "xhdpi";
            default:
                return "undefined(" + displayMetrics.densityDpi + ")";
        }
    }

    public static float m5080c(Context context, Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return (float) displayMetrics.densityDpi;
    }

    public static float m5081d(Context context, Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }
}
