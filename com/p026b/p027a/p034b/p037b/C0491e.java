package com.p026b.p027a.p034b.p037b;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.p026b.p027a.p034b.C0506d;
import com.p026b.p027a.p034b.p035a.C0477e;
import com.p026b.p027a.p034b.p035a.C0478f;
import com.p026b.p027a.p034b.p035a.C0484l;
import com.p026b.p027a.p034b.p039d.C0498c;

/* compiled from: ImageDecodingInfo */
public class C0491e {
    private final String f1440a;
    private final String f1441b;
    private final C0478f f1442c;
    private final C0477e f1443d;
    private final C0484l f1444e;
    private final C0498c f1445f;
    private final Object f1446g;
    private final Options f1447h = new Options();

    public C0491e(String str, String str2, C0478f c0478f, C0484l c0484l, C0498c c0498c, C0506d c0506d) {
        this.f1440a = str;
        this.f1441b = str2;
        this.f1442c = c0478f;
        this.f1443d = c0506d.m3051m();
        this.f1444e = c0484l;
        this.f1445f = c0498c;
        this.f1446g = c0506d.m3054p();
        m2995a(c0506d.m3052n(), this.f1447h);
    }

    private void m2995a(Options options, Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        if (VERSION.SDK_INT >= 10) {
            m2996b(options, options2);
        }
        if (VERSION.SDK_INT >= 11) {
            m2997c(options, options2);
        }
    }

    @TargetApi(10)
    private void m2996b(Options options, Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void m2997c(Options options, Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public String m2998a() {
        return this.f1440a;
    }

    public String m2999b() {
        return this.f1441b;
    }

    public C0478f m3000c() {
        return this.f1442c;
    }

    public C0477e m3001d() {
        return this.f1443d;
    }

    public C0484l m3002e() {
        return this.f1444e;
    }

    public C0498c m3003f() {
        return this.f1445f;
    }

    public Object m3004g() {
        return this.f1446g;
    }

    public Options m3005h() {
        return this.f1447h;
    }
}
