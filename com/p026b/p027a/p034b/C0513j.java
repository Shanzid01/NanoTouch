package com.p026b.p027a.p034b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.p026b.p027a.p028a.p029a.C0450b;
import com.p026b.p027a.p028a.p029a.p031b.C0456a;
import com.p026b.p027a.p028a.p032b.C0459c;
import com.p026b.p027a.p028a.p032b.p033a.C0460a;
import com.p026b.p027a.p034b.p035a.C0479g;
import com.p026b.p027a.p034b.p035a.C0482j;
import com.p026b.p027a.p034b.p037b.C0487d;
import com.p026b.p027a.p034b.p039d.C0498c;
import com.p026b.p027a.p041c.C0524d;
import java.util.concurrent.Executor;

/* compiled from: ImageLoaderConfiguration */
public class C0513j {
    public static final C0482j f1527a = C0482j.FIFO;
    private Context f1528b;
    private int f1529c = 0;
    private int f1530d = 0;
    private int f1531e = 0;
    private int f1532f = 0;
    private CompressFormat f1533g = null;
    private int f1534h = 0;
    private Executor f1535i = null;
    private Executor f1536j = null;
    private boolean f1537k = false;
    private boolean f1538l = false;
    private int f1539m = 3;
    private int f1540n = 4;
    private boolean f1541o = false;
    private C0482j f1542p = f1527a;
    private int f1543q = 0;
    private int f1544r = 0;
    private int f1545s = 0;
    private C0459c<String, Bitmap> f1546t = null;
    private C0450b f1547u = null;
    private C0456a f1548v = null;
    private C0498c f1549w = null;
    private C0487d f1550x;
    private C0506d f1551y = null;
    private boolean f1552z = false;

    public C0513j(Context context) {
        this.f1528b = context.getApplicationContext();
    }

    public C0513j m3111a(C0459c<String, Bitmap> c0459c) {
        if (this.f1543q != 0) {
            C0524d.m3154c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        this.f1546t = c0459c;
        return this;
    }

    public C0511h m3110a() {
        m3091b();
        return new C0511h();
    }

    private void m3091b() {
        if (this.f1535i == null) {
            this.f1535i = C0486a.m2983a(this.f1539m, this.f1540n, this.f1542p);
        } else {
            this.f1537k = true;
        }
        if (this.f1536j == null) {
            this.f1536j = C0486a.m2983a(this.f1539m, this.f1540n, this.f1542p);
        } else {
            this.f1538l = true;
        }
        if (this.f1547u == null) {
            if (this.f1548v == null) {
                this.f1548v = C0486a.m2978a();
            }
            this.f1547u = C0486a.m2980a(this.f1528b, this.f1548v, this.f1544r, this.f1545s);
        }
        if (this.f1546t == null) {
            this.f1546t = C0486a.m2981a(this.f1543q);
        }
        if (this.f1541o) {
            this.f1546t = new C0460a(this.f1546t, C0479g.m2972a());
        }
        if (this.f1549w == null) {
            this.f1549w = C0486a.m2985b(this.f1528b);
        }
        if (this.f1550x == null) {
            this.f1550x = C0486a.m2982a(this.f1552z);
        }
        if (this.f1551y == null) {
            this.f1551y = C0506d.m3038u();
        }
    }
}
