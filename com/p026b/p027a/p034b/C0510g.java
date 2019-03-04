package com.p026b.p027a.p034b;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.p026b.p027a.p028a.p029a.C0450b;
import com.p026b.p027a.p034b.p035a.C0476d;
import com.p026b.p027a.p034b.p035a.C0478f;
import com.p026b.p027a.p034b.p035a.C0479g;
import com.p026b.p027a.p034b.p035a.C0483k;
import com.p026b.p027a.p034b.p038c.C0493a;
import com.p026b.p027a.p034b.p038c.C0495c;
import com.p026b.p027a.p041c.C0521a;
import com.p026b.p027a.p041c.C0524d;

/* compiled from: ImageLoader */
public class C0510g {
    public static final String f1498a = C0510g.class.getSimpleName();
    private static volatile C0510g f1499f;
    private C0511h f1500b;
    private C0514k f1501c;
    private final C0476d f1502d = new C0483k();
    private final C0493a f1503e = new C0495c();

    public static C0510g m3081a() {
        if (f1499f == null) {
            synchronized (C0510g.class) {
                if (f1499f == null) {
                    f1499f = new C0510g();
                }
            }
        }
        return f1499f;
    }

    protected C0510g() {
    }

    public synchronized void m3083a(C0511h c0511h) {
        if (c0511h == null) {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        } else if (this.f1500b == null) {
            if (c0511h.f1523t) {
                C0524d.m3151a("Initialize ImageLoader with configuration", new Object[0]);
            }
            this.f1501c = new C0514k(c0511h);
            this.f1500b = c0511h;
        } else {
            C0524d.m3154c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }

    public void m3084a(String str, ImageView imageView, C0506d c0506d, C0476d c0476d) {
        m3082f();
        if (imageView == null) {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        C0476d c0476d2;
        C0506d c0506d2;
        if (c0476d == null) {
            c0476d2 = this.f1502d;
        } else {
            c0476d2 = c0476d;
        }
        if (c0506d == null) {
            c0506d2 = this.f1500b.f1522s;
        } else {
            c0506d2 = c0506d;
        }
        if (str == null || str.length() == 0) {
            this.f1501c.m3124b(imageView);
            c0476d2.mo930a(str, imageView);
            if (c0506d2.m3040b()) {
                imageView.setImageResource(c0506d2.m3046h());
            } else {
                imageView.setImageBitmap(null);
            }
            c0476d2.mo931a(str, (View) imageView, null);
            return;
        }
        C0478f a = C0521a.m3146a(imageView, this.f1500b.f1505b, this.f1500b.f1506c);
        String a2 = C0479g.m2971a(str, a);
        this.f1501c.m3120a(imageView, a2);
        c0476d2.mo930a(str, imageView);
        Bitmap bitmap = (Bitmap) this.f1500b.f1518o.mo919a(a2);
        if (bitmap == null || bitmap.isRecycled()) {
            if (c0506d2.m3039a()) {
                imageView.setImageResource(c0506d2.m3045g());
            } else if (c0506d2.m3048j()) {
                imageView.setImageBitmap(null);
            }
            this.f1501c.m3121a(new C0517n(this.f1501c, new C0516m(str, imageView, a, a2, c0506d2, c0476d2, this.f1501c.m3118a(str)), c0506d2.m3058t()));
            return;
        }
        if (this.f1500b.f1523t) {
            C0524d.m3153b("Load image from memory cache [%s]", a2);
        }
        if (c0506d2.m3043e()) {
            this.f1501c.m3122a(new C0520q(this.f1501c, bitmap, new C0516m(str, imageView, a, a2, c0506d2, c0476d2, this.f1501c.m3118a(str)), c0506d2.m3058t()));
            return;
        }
        c0506d2.m3057s().mo935a(bitmap, imageView);
        c0476d2.mo931a(str, (View) imageView, bitmap);
    }

    private void m3082f() {
        if (this.f1500b == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public C0450b m3085b() {
        m3082f();
        return this.f1500b.f1519p;
    }

    public void m3086c() {
        this.f1501c.m3119a();
    }

    public void m3087d() {
        this.f1501c.m3123b();
    }

    public void m3088e() {
        this.f1501c.m3125c();
    }
}
