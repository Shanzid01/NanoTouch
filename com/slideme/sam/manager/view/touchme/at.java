package com.slideme.sam.manager.view.touchme;

import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: SlidingTabSelector */
public class at {
    public float f3806a = 0.0f;
    public float f3807b = 0.0f;
    final /* synthetic */ ar f3808c;
    private int f3809d;
    private long f3810e;

    protected at(ar arVar) {
        this.f3808c = arVar;
    }

    public long m6095a() {
        return System.currentTimeMillis() - this.f3810e;
    }

    public void m6096a(int i) {
        this.f3809d = i;
    }

    public void m6097b() {
        this.f3810e = System.currentTimeMillis();
    }

    public float m6098c() {
        float a = ((float) m6095a()) / ((float) this.f3809d);
        return a <= TextTrackStyle.DEFAULT_FONT_SCALE ? a : TextTrackStyle.DEFAULT_FONT_SCALE;
    }

    public float m6099d() {
        return this.f3806a - this.f3807b;
    }

    public boolean m6100e() {
        return ((long) this.f3809d) - m6095a() >= 0;
    }
}
