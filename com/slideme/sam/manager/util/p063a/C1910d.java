package com.slideme.sam.manager.util.p063a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.slideme.sam.manager.model.p054b.C1829c;

@SuppressLint({"NewApi"})
/* compiled from: ScreenSizeCheckHelper */
public abstract class C1910d {
    public static boolean m5754a(Configuration configuration, int i) {
        return i <= 0 || configuration.smallestScreenWidthDp >= i;
    }

    public static Point m5753a(Context context) {
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (C1829c.m5504f() < 13) {
            point.x = defaultDisplay.getWidth();
            point.y = defaultDisplay.getHeight();
        } else {
            defaultDisplay.getSize(point);
        }
        return point;
    }
}
