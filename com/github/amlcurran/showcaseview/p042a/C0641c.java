package com.github.amlcurran.showcaseview.p042a;

import android.graphics.Point;
import android.view.View;

/* compiled from: ViewTarget */
public class C0641c implements C0639a {
    private final View f1623b;

    public C0641c(View view) {
        this.f1623b = view;
    }

    public Point mo1090a() {
        int[] iArr = new int[2];
        this.f1623b.getLocationInWindow(iArr);
        return new Point(iArr[0] + (this.f1623b.getWidth() / 2), iArr[1] + (this.f1623b.getHeight() / 2));
    }
}
