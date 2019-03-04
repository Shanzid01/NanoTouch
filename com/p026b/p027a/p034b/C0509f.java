package com.p026b.p027a.p034b;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import com.p026b.p027a.p034b.p035a.C0477e;
import com.p026b.p027a.p034b.p038c.C0493a;
import com.p026b.p027a.p034b.p040e.C0507a;

/* compiled from: DisplayImageOptions */
public class C0509f {
    private int f1484a;
    private int f1485b;
    private int f1486c;
    private boolean f1487d;
    private boolean f1488e;
    private boolean f1489f;
    private C0477e f1490g;
    private Options f1491h;
    private int f1492i;
    private Object f1493j;
    private C0507a f1494k;
    private C0507a f1495l;
    private C0493a f1496m;
    private Handler f1497n;

    public C0509f() {
        this.f1484a = 0;
        this.f1485b = 0;
        this.f1486c = 0;
        this.f1487d = false;
        this.f1488e = false;
        this.f1489f = false;
        this.f1490g = C0477e.IN_SAMPLE_POWER_OF_2;
        this.f1491h = new Options();
        this.f1492i = 0;
        this.f1493j = null;
        this.f1494k = null;
        this.f1495l = null;
        this.f1496m = C0486a.m2984b();
        this.f1497n = null;
        this.f1491h.inPurgeable = true;
        this.f1491h.inInputShareable = true;
    }

    public C0509f m3075a(int i) {
        this.f1484a = i;
        return this;
    }

    public C0509f m3074a() {
        this.f1488e = true;
        return this;
    }

    public C0509f m3079b() {
        this.f1489f = true;
        return this;
    }

    public C0509f m3077a(C0477e c0477e) {
        this.f1490g = c0477e;
        return this;
    }

    public C0509f m3076a(Config config) {
        this.f1491h.inPreferredConfig = config;
        return this;
    }

    public C0509f m3078a(C0506d c0506d) {
        this.f1484a = c0506d.f1470a;
        this.f1485b = c0506d.f1471b;
        this.f1486c = c0506d.f1472c;
        this.f1487d = c0506d.f1473d;
        this.f1488e = c0506d.f1474e;
        this.f1489f = c0506d.f1475f;
        this.f1490g = c0506d.f1476g;
        this.f1491h = c0506d.f1477h;
        this.f1492i = c0506d.f1478i;
        this.f1493j = c0506d.f1479j;
        this.f1494k = c0506d.f1480k;
        this.f1495l = c0506d.f1481l;
        this.f1496m = c0506d.f1482m;
        this.f1497n = c0506d.f1483n;
        return this;
    }

    public C0506d m3080c() {
        return new C0506d();
    }
}
