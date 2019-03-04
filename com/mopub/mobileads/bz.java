package com.mopub.mobileads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View.OnTouchListener;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: ToolbarWidget */
class bz {
    private final Context f2477a;
    private float f2478b = TextTrackStyle.DEFAULT_FONT_SCALE;
    private int f2479c = 17;
    private boolean f2480d;
    private String f2481e;
    private boolean f2482f;
    private Drawable f2483g;
    private OnTouchListener f2484h;
    private int f2485i = 0;
    private int f2486j = 9;
    private int f2487k = 11;

    bz(Context context) {
        this.f2477a = context;
    }

    bz m4618a(float f) {
        this.f2478b = f;
        return this;
    }

    bz m4619a(int i) {
        this.f2479c = i;
        return this;
    }

    bz m4617a() {
        this.f2480d = true;
        return this;
    }

    bz m4621a(String str) {
        this.f2480d = true;
        this.f2481e = str;
        return this;
    }

    bz m4620a(Drawable drawable) {
        this.f2482f = true;
        this.f2483g = drawable;
        return this;
    }

    bz m4623b(int i) {
        this.f2486j = i;
        return this;
    }

    bz m4624c(int i) {
        this.f2485i = i;
        return this;
    }

    by m4622b() {
        return new by();
    }
}
